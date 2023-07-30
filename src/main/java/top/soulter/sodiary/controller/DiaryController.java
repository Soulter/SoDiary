package top.soulter.sodiary.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@Slf4j
@CrossOrigin
@RequestMapping("api/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;
    @Autowired
    UserService userService;

    @RequestMapping("/fetch")
    @GetMapping
    @CachePut(value = "diary", key = "#page + '-' +#size")
    public List<Diary> fetchDiary(@RequestParam("page") int page, @RequestParam("size") int size, HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Diary> diaries;
        if (session.getAttribute("is_unlock") != null && "true".equals(session.getAttribute("is_unlock"))){
            diaries = diaryService.fetchDiary(page, size, false);
        }else{
            diaries = diaryService.fetchDiary(page, size, true);
        }
        log.info("fetch diary page: " + page + " size: " + size);

        System.out.println(diaries);
        return diaries;
    }


    // detail by id
    @RequestMapping("/detail")
    @GetMapping
    public Result fetchDiaryById(@RequestParam("id") long id, HttpServletRequest request){
        log.info("fetch diary id: " + id);
        HttpSession session = request.getSession();
        if (session.getAttribute("is_unlock") != null && "true".equals(session.getAttribute("is_unlock"))){
            return diaryService.fetchDiaryById(id, false);
        }else{
            return diaryService.fetchDiaryById(id, true);
        }
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
