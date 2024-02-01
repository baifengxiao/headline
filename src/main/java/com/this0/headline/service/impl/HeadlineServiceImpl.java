package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.Headline;
import com.this0.headline.service.HeadlineService;
import com.this0.headline.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author yupen
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-02-01 11:32:10
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




