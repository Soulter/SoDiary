package top.soulter.sodiary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.soulter.sodiary.dao.UserDao;
import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.User;
import top.soulter.sodiary.service.UserService;

import static top.soulter.sodiary.util.Presets.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result checkUser(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        qw.eq("password", user.getPassword());
        System.out.println();
        Result result = new Result();
        if (userDao.selectList(qw).size() > 0){
            result.setCode(LOGIN_SUCCESS);
        }else{
            result.setCode(LOGIN_FAILED_INVALID_USR_OR_PSW);
            result.setMsg(MSG_LOGIN_FAILED_INVALID_USR_OR_PSW);
        }
        return result;
    }

    @Override
    public Result registerUser() {
        return null;
    }
}
