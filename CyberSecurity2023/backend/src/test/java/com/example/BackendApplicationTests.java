package com.example;

import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BackendApplicationTests {

    //引入资源
    @Resource
    private UserMapper userMapper;

    @Test
    void testMapper(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void contextLoads() {
    }

}
