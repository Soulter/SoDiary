package top.soulter.sodiary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.soulter.sodiary.domain.User;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
