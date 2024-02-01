package com.this0.headline.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

import java.util.HashMap;
import java.util.Map;

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
        //TODO，没输入用户或密码那种情况没有处理
        queryWrapper.eq("username", user.getUsername()).eq("user_pwd", MD5Util.encrypt(user.getUserPwd()));
        User userlogin = userMapper.selectOne(queryWrapper);

        Long uid = (userlogin != null) ? userlogin.getUid() : null;


        HashMap<String, Object> map = new HashMap<>();

        if (uid != null) {
            String token = jwtHelper.createToken(uid);
            map.put("token", token);
        } else {
            return Result.build(504, ResultCodeEnum.NOTLOGIN);
        }

        return Result.ok(map);
    }
}





