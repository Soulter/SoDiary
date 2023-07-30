package top.soulter.sodiary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.soulter.sodiary.dao.DiaryDao;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.service.DiaryService;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static top.soulter.sodiary.util.Presets.*;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public List<Diary> fetchDiary(int page, int size, boolean lock) {
        QueryWrapper<Diary> qw = new QueryWrapper<>();
//        long count = diaryDao.selectCount(qw);
//        long shouldPage = (count%size == 0 ? count/size : count/size + 1) - page + 1;
        QueryWrapper<Diary> qw2 = new QueryWrapper<>();
        qw2.orderByDesc("id");
//        qw2.select("title", "time", "content");
//        List<Diary> diaries = diaryDao.selectList(qw);
//        System.out.println(diaries);
        Page<Diary> diaryPage = diaryDao.selectPage(new Page<>(page, size), qw2);
        System.out.println("数据为："+diaryPage.getRecords());
        System.out.println("总数为："+diaryPage.getTotal()+",总页数为："+diaryPage.getPages());
        System.out.println("当前页为："+diaryPage.getCurrent()+",每页限制："+diaryPage.getSize());

        List<Diary> diaries = diaryPage.getRecords();
        if (lock){
            for (Diary diary : diaries) {
                if (diary.isLock()){
                    diary.setTitle("***");
                    diary.setContent("这是一篇加密日记");
                }
            }
        }

        for (Diary diary : diaries) {
            String content = diary.getContent();
            int index = content.indexOf("---");
            if (index != -1) {
                String brief = content.substring(0, index);
                String[] split = brief.split("\n");
                for(String i : split) {
                    if(i.startsWith("brief")) {
                        diary.setBrief(i.replaceFirst("brief", ""));
                        diary.setContent("");
                    }
                    if(i.startsWith("bg")) {
                        diary.setBg(i.replaceFirst("bg", ""));
                    }
                }
            }
        }

        return diaries;
    }

    @Override
    public Result fetchDiaryById(long id, boolean lock) {
        QueryWrapper<Diary> qw = new QueryWrapper<>();
        qw.eq("id", id);
        Diary diary = diaryDao.selectOne(qw);
        if (diary == null){
            return new Result(0 ,"日记不存在");
        }
        if (lock && diary.isLock()){
            diary.setTitle("***");
            diary.setContent("这是一篇加密日记");
        }
        String content = diary.getContent();
        int index = content.indexOf("---");
        if (index != -1) {
            String brief = content.substring(0, index);
            String[] split = brief.split("\n");
            for(String i : split) {
                if(i.startsWith("brief")) {
                    diary.setBrief(i.replaceFirst("brief", ""));
                }
                if(i.startsWith("bg")) {
                    diary.setBg(i.replaceFirst("bg", ""));
                }
            }
        }
        content = content.substring(index + 3);
        diary.setContent(content);
        return new Result(1, "获取成功", diary);
    }

    @Override
    public Boolean submitDiary(Diary diary) {
        try{
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
            diary.setTime(ft.format(dNow));
            diaryDao.insert(diary);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateDiary(Diary diary) {
        try{
//            Calendar calendar= Calendar.getInstance();
//            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm");
//            diary.setTime(dateFormat.format(calendar.getTime()));
            UpdateWrapper<Diary> uw = new UpdateWrapper<>();
            uw.eq("id", diary.getId());
            diaryDao.update(diary, uw);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteDiary(long id) {
        try{
            QueryWrapper<Diary> uw = new QueryWrapper<>();
            uw.eq("id", id);
            diaryDao.delete(uw);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
