package com.example.sys.controller;

import com.example.common.vo.Result;
import com.example.sys.entity.User;
import com.example.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author vh
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public Result<List<User>> getAllUser(){
        List<User> list = userService.list();
        return Result.success(list,"Successfully searched all user");
    }

    @PostMapping ("/login")
    public Result<Map<String, Object>> login(@RequestBody User user){
        Map<String, Object> data = userService.login(user);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20002,"Username Or Password Wrong");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {
        //查找redis里token对应的值
        Map<String, Object> data = userService.getUserInfo(token);
        System.out.println(data);

        if(data != null){

            return Result.success(data);
        }
        return Result.fail(20003,"登录信息无效，请重新登录");
    }

    @PostMapping("/logout")
    public Result<String> logout(@RequestHeader("X-Token") String token){
        userService.logout(token);
        return Result.success("Logout successfully");
    }

    @GetMapping("/search")
    public Result<Map<String, Object>> getUserList(@RequestParam(value = "username", required = false) String username,
                                          @RequestParam(value = "phone", required = false) String phone,
                                          @RequestParam(value = "pageNo") Long pageNo,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestHeader("X-Token") String token){

        Boolean validUser = userService.validUser(token);

        if(validUser){
            Map<String, Object> userList = userService.searchUser(username, phone, pageNo, pageSize);
            return Result.success(userList,"Found all user");
        }

        return Result.fail("Invalid user");

    }

    @GetMapping("/addUser")
    public Result<User> addUser(@RequestParam("username") String userName, @RequestParam("phone") String phone){

        User user = userService.addUser(userName, phone);
        if(user != null){
            return Result.success(user);
        }

        return Result.fail();
    }

}
