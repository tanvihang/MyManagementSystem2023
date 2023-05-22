package com.example.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> login(User user) {

//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(User::getUsername,user.getUsername());
//        wrapper.eq(User::getPassword, user.getPassword());
//        User loginUser = this.baseMapper.selectOne(wrapper);

        //利用mapper查找用户
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        User loginUser = this.baseMapper.findUserWithUsernameAndPassword(map);

        if(loginUser != null){
            String key = "user:"+UUID.randomUUID();

            //保存到redis内
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser,30, TimeUnit.MINUTES);

            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        Object obj = redisTemplate.opsForValue().get(token);

        if(obj != null){
            //将obj反序列化成User类
            User loginUser = JSON.parseObject(JSON.toJSONString(obj),User.class);

            Map<String, Object> data = new HashMap<>();

            //放入返回类型
            List<String> roleList = this.baseMapper.getRoleNameByUserId(loginUser.getId());
            data.put("name", loginUser.getUsername());
            data.put("roles",roleList);

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

    @Override
    public Map<String, Object> searchUser(String username, String phone, Long pageNo, Integer pageSize) {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(username),User::getUsername,username);
        wrapper.eq(StringUtils.hasLength(phone),User::getPhone, phone);

        Page<User> myPage = new Page<>(pageNo,pageSize);

        this.baseMapper.selectPage(myPage,wrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("total", myPage.getTotal());
        data.put("rows", myPage.getRecords());

        return data;
    }

    @Override
    public Boolean validUser(String token) {
        Object obj = redisTemplate.opsForValue().get(token);

        if(obj!=null){
            return true;
        }

        return false;
    }

    @Override
    public User addUser(String userName, String phone) {

        User user = new User();
        user.setUsername(userName);
        user.setPhone(phone);
        user.setPassword("111111");

        LambdaQueryWrapper<User> mywrapper = new LambdaQueryWrapper<>();
        mywrapper.eq(User::getUsername, userName);
        mywrapper.eq(User::getPhone, phone);

        User user1 = this.baseMapper.selectOne(mywrapper);

        if(user1 == null){
            this.baseMapper.insert(user);

            return user;
        }

        return null;
    }


}
