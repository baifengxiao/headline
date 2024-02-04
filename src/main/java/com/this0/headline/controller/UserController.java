package com.this0.headline.controller;

import com.this0.headline.pojo.User;
import com.this0.headline.service.UserService;
import com.this0.headline.util.JwtHelper;
import com.this0.headline.util.Result;
import com.this0.headline.util.ResultCodeEnum;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private JwtHelper jwtHelper;

    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token) {
        boolean isExpiration = jwtHelper.isExpiration(token);
        if (isExpiration || StringUtils.isEmpty(token) ) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        } else {
            return Result.ok(null);
        }

    }

    @PostMapping("/login")
    public Result Login(@RequestBody User user) {

        Result result = userService.login(user);
        return result;
    }

    @GetMapping("/getUserInfo")
    public Result GetUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }

    @PostMapping("/checkUserName")
    public Result CheckUserName(String username) {
        Result result = userService.checkUserName(username);
        return result;
    }

    @PostMapping("/regist")
    public Result Regist(@RequestBody User user) {
        Result result = userService.regest(user);
        return result;
    }
}
