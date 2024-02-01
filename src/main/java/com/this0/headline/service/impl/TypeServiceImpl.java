package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.Type;
import com.this0.headline.service.TypeService;
import com.this0.headline.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author yupen
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-02-01 11:32:10
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




