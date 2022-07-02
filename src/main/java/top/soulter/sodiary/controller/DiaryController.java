package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.service.DiaryService;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/fetch")
    @GetMapping
    public List<Diary> fetchDiary(@RequestParam("page") int page, @RequestParam("size") int size){
        List<Diary> diaries = diaryService.fetchDiary(page, size);
        System.out.println(diaries);
        return diaries;
    }

}
