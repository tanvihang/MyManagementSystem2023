package com.example.sys.service;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);

    Map<String, Object> searchUser(String username, String phone, Long pageNo, Integer pageSize);

    Boolean validUser(String token);

    User addUser(String userName, String phone);
}
