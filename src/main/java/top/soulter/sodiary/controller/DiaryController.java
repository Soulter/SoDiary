package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.User;
import top.soulter.sodiary.service.DiaryService;
import top.soulter.sodiary.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static top.soulter.sodiary.util.Presets.LOGIN_SUCCESS;

@RestController
@CrossOrigin
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;
    @Autowired
    UserService userService;

    @RequestMapping("/fetch")
    @GetMapping
    public List<Diary> fetchDiary(@RequestParam("page") int page, @RequestParam("size") int size, HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Diary> diaries;
        if (session.getAttribute("is_unlock") != null && "true".equals(session.getAttribute("is_unlock"))){
            diaries = diaryService.fetchDiary(page, size, false);
        }else{
            diaries = diaryService.fetchDiary(page, size, true);
        }

        System.out.println(diaries);
        return diaries;
    }


    @RequestMapping("/unlock")
    @PostMapping
    public Result lockVerify(@RequestBody User user, HttpServletRequest request){
        Result result = userService.checkUser(user);
        System.out.println(result);
        if (result.getCode() == LOGIN_SUCCESS){
            HttpSession session = request.getSession();
            session.setAttribute("is_unlock","true");
        }
        return result;
    }

}
