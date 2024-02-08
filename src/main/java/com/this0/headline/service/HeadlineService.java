package com.this0.headline.service;

import com.this0.headline.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.this0.headline.pojo.dto.NewsDto;
import com.this0.headline.util.Result;

/**
* @author yupen
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-02-01 11:32:10
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewsPage(NewsDto newsDto);

    Result showHeadlineDetail(Integer hid);


    Result publish(String token, Headline headline);

    Result findHeadlineByHid(String hid);

    Result updateHeadline(Headline headline);

    Result removeByHid(String hid);
}
