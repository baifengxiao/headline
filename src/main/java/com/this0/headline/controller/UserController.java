package com.this0.headline.controller;

import com.this0.headline.pojo.User;
import com.this0.headline.service.UserService;
import com.this0.headline.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result Login(@RequestBody User user) {

        Result result = userService.login(user);
        return result;
    }
    @GetMapping("/getUserInfo")
    public Result GetUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);
        return result;
    }

    @PostMapping("/checkUserName")
    public Result CheckUserName( String username ){
        Result result = userService.checkUserName(username);
        return result;
    }
    @PostMapping("/regist")
    public Result Regist(@RequestBody User user){
        Result result = userService.regest(user);
        return result;
    }
}
