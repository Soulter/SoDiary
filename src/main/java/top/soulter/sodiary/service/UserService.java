package top.soulter.sodiary.service;

import top.soulter.sodiary.domain.Result;
import top.soulter.sodiary.domain.User;

public interface UserService {
    Result checkUser(User user);
    Result registerUser();
}
