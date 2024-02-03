package com.this0.headline.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.this0.headline.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.this0.headline.pojo.dto.NewsDto;
import com.this0.headline.pojo.vo.NewsVo;
import org.apache.ibatis.annotations.Param;

/**
* @author yupen
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-02-01 11:32:10
* @Entity com.this0.headline.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Headline> selectMyPage(IPage<NewsVo> newsVoPage, @Param("newsDto") NewsDto newsDto);

}




