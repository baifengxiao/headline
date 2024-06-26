package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.User;
import com.this0.headline.service.UserService;
import com.this0.headline.mapper.UserMapper;
import com.this0.headline.util.JwtHelper;
import com.this0.headline.util.MD5Util;
import com.this0.headline.util.Result;
import com.this0.headline.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author yupen
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2024-02-01 11:32:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;


    @Override
    public Result login(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername()).eq("user_pwd", MD5Util.encrypt(user.getUserPwd()));
        User userlogin = userMapper.selectOne(queryWrapper);

        Long uid = (userlogin != null) ? userlogin.getUid() : null;

        HashMap<String, Object> map = new HashMap<>();

        if (uid != null) {
            String token = jwtHelper.createToken(uid);
            map.put("token", token);
        } else {
            return Result.build(null, ResultCodeEnum.LOGIN_ERROR);
        }

        return Result.ok(map);
    }

    @Override
    public Result getUserInfo(String token) {

        if (jwtHelper.isExpiration(token)) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        Long userId = jwtHelper.getUserId(token);
        User user = baseMapper.selectById(userId);

        HashMap<String, Object> map = new HashMap<>();
        map.put("loginUser", user);

        return Result.ok(map);
    }

    @Override
    public Result checkUserName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userMapper.selectOne(wrapper);
        if (user != null) {
            System.out.println("不能注册");
            return Result.build(null, ResultCodeEnum.USERNAME_USED);

        } else {
            System.out.println("可以注册");
            return Result.ok(null);
        }

    }

    @Override
    public Result regest(User user) {

        Result result = checkUserName(user.getUsername());
        if (result.getCode() == 200) {
            int insert = userMapper.insert(user);
            return Result.ok(null);

        } else return Result.build(null, ResultCodeEnum.USERNAME_USED);

    }
}





