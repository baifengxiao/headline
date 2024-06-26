package com.this0.headline.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.this0.headline.pojo.Headline;
import com.this0.headline.pojo.dto.NewsDto;
import com.this0.headline.pojo.vo.NewsVo;

import com.this0.headline.service.HeadlineService;
import com.this0.headline.mapper.HeadlineMapper;
import com.this0.headline.util.JwtHelper;
import com.this0.headline.util.Result;
import com.this0.headline.util.ResultCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yupen
 * @description 针对表【news_headline】的数据库操作Service实现
 * @createDate 2024-02-01 11:32:10
 */
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline> implements HeadlineService {

    @Resource
    private HeadlineMapper headlineMapper;


    @Resource
    private JwtHelper jwtHelper;

    @Override
    public Result findNewsPage(NewsDto newsDto) {

//        分页参数
        Page<NewsVo> newsVoPage = new Page<>(newsDto.getPageNum(), newsDto.getPageSize());

//        查
        IPage<Headline> selectedNoPage = headlineMapper.selectMyPage(newsVoPage, newsDto);

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageData", selectedNoPage.getRecords());
        map.put("pageNum", selectedNoPage.getCurrent());
        map.put("pageSize", selectedNoPage.getSize());
        map.put("totalSize", selectedNoPage.getTotal());
        map.put("totalPage", selectedNoPage.getPages());

        HashMap<Object, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageInfo", map);

        return Result.ok(pageInfo);
    }

    @Override
    @Transactional
    public Result showHeadlineDetail(Integer hid) {
        //查
        Map detail = headlineMapper.selectDetail(hid);

        Headline newHeadline = new Headline();

        newHeadline.setHid(hid);

        System.out.println("detail.get(\"page_views\").getClass() = " + detail.get("pageViews").getClass());
        //上一句输出：detail.get("page_views").getClass() = class java.lang.Integer，
        int i = (Integer) detail.get("pageViews") + 1;   //TODO,detail.get("page_views")它本身就是Integer类型，为什么还要把她强转成Integer
        newHeadline.setPageViews(i);

        baseMapper.updateById(newHeadline);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("headline", detail);

        return Result.ok(map);
    }

    @Override
    public Result publish(String token, Headline headline) {


        headline.setPublisher(jwtHelper.getUserId(token).intValue());

        headline.setCreateTime(LocalDateTime.now());
        headline.setUpdateTime(LocalDateTime.now());
        headline.setPublisher(jwtHelper.getUserId(token).intValue());

        headlineMapper.insert(headline);

        return Result.ok(null);
    }

    @Override
    public Result findHeadlineByHid(String hid) {
        Headline headline = headlineMapper.selectById(hid);
        HashMap<String, Object> headlinemap = new HashMap<>();
        headlinemap.put("headline", headline);

        return Result.ok(headlinemap);
    }

    @Override
    public Result updateHeadline(Headline headline) {
        Integer version = headlineMapper.selectById(headline).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(LocalDateTime.now());

        headlineMapper.updateById(headline);
        return Result.ok(null);
    }

    @Override
    public Result removeByHid(String hid) {
        headlineMapper.deleteById(hid);
        return Result.ok(null);
    }


}




