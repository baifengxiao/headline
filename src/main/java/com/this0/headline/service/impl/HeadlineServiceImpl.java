package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.Headline;
import com.this0.headline.pojo.dto.NewsDto;
import com.this0.headline.pojo.vo.NewsVo;
import com.this0.headline.service.HeadlineService;
import com.this0.headline.mapper.HeadlineMapper;
import com.this0.headline.util.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yupen
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-02-01 11:32:10
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline> implements HeadlineService{

    @Resource
    private HeadlineMapper headlineMapper;
    @Override
    public Result findNewsPage(NewsDto newsDto) {

//        再分页
        Page<NewsVo> newsVoPage = new Page<>(newsDto.getPageNum(), newsDto.getPageSize());

//        先查
        List<NewsVo> voList = headlineMapper.selectNoPage(newsDto, newsVoPage);

        System.out.println("list = " + voList);

        return Result.ok(voList);
    }
}




