package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.service.DiaryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static top.soulter.sodiary.util.Presets.LOGIN_SUCCESS;

@RestController
@RequestMapping("/fetch")
public class FetchDiaryController {

    @Autowired
    DiaryService diaryService;

    @PostMapping
    public List<Diary> fetchDiary(){
        List<Diary> diaries = diaryService.fetchDiary();
        System.out.println(diaries);
        return diaries;
    }
}
