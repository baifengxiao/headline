package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.Type;
import com.this0.headline.service.TypeService;
import com.this0.headline.mapper.TypeMapper;
import com.this0.headline.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
* @author yupen
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-02-01 11:32:10
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Result findAllTypes() {
        List<Type> list = typeMapper.selectList(null);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",list);
        return Result.ok(list);

    }
}




