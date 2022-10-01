package top.soulter.sodiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.User;
import top.soulter.sodiary.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static top.soulter.sodiary.util.Presets.LOGIN_SUCCESS;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;



    @PostMapping
    public Result userLogin(@RequestBody User user, HttpServletRequest request){
        Result result = userService.checkUser(user);
        System.out.println(result);
        if (result.getCode() == LOGIN_SUCCESS){
            HttpSession session = request.getSession();
            session.setAttribute("is_login","true");
            session.setAttribute("username", user.getUsername());
        }
        return result;
    }


}
