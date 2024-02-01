package com.this0.headline.service;

import com.this0.headline.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.this0.headline.util.Result;

/**
* @author yupen
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-02-01 11:32:10
*/
public interface UserService extends IService<User> {

    Result login(User user);
}
