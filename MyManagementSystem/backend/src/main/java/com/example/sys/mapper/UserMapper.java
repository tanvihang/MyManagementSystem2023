package com.example.sys.mapper;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
public interface UserMapper extends BaseMapper<User> {
    public List<String> getRoleNameByUserId(Integer userId);

    public User findUserWithUsernameAndPassword(HashMap<String, Object> map);
}
