package com.this0.headline.controller;

import com.this0.headline.pojo.User;
import com.this0.headline.service.UserService;
import com.this0.headline.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
