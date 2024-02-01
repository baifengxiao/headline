package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.User;
import com.this0.headline.service.UserService;
import com.this0.headline.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author yupen
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-02-01 11:32:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




