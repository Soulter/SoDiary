package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public List<Diary> fetchDiary(@RequestParam("page") int page, @RequestParam("size") int size){
        List<Diary> diaries = diaryService.fetchDiary(page, size);
        System.out.println(diaries);
        return diaries;
    }
}
