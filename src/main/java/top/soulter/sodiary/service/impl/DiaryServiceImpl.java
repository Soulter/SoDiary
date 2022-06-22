package top.soulter.sodiary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.soulter.sodiary.dao.DiaryDao;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.service.DiaryService;

import java.util.List;

import static top.soulter.sodiary.util.Presets.*;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public List<Diary> fetchDiary() {
        QueryWrapper<Diary> qw = new QueryWrapper<>();
        qw.select("title", "time", "content");
        List<Diary> diaries = diaryDao.selectList(qw);
        System.out.println(diaries);
        return diaries;
    }

}
