package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.soulter.sodiary.domain.Diary;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.User;
import top.soulter.sodiary.service.DiaryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static top.soulter.sodiary.util.Presets.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DiaryService diaryService;

    @PostMapping
    public Result checkStatus(HttpServletRequest request){
        Result result = new Result();
        HttpSession session = request.getSession();
        if ("true".equals(session.getAttribute("is_login"))){
            result.setCode(LOGIN_SUCCESS);
            User user = new User();
            user.setUsername(String.valueOf(session.getAttribute("username")));
            result.setMsg(user);
            System.out.println("检测登录态成功");
        }else{
            result.setCode(PERMISSION_DENIED);
        }
        System.out.println(result);
        return result;
    }

    @PostMapping
    @RequestMapping("/newDiary")
    public Result submitDiary(@RequestBody Diary diary, HttpServletRequest request){
        Result result = new Result();
        HttpSession session = request.getSession();
        if ("true".equals(session.getAttribute("is_login"))){
            try{
                diaryService.submitDiary(diary);
                result.setCode(SUBMIT_SUCCESS);
            }catch (Exception e){
                e.printStackTrace();
                result.setCode(SERVER_ERR);
            }
        }else{
            result.setCode(PERMISSION_DENIED);
        }
        return result;
    }
}
