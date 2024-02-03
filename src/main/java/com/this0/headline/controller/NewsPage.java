package com.this0.headline.controller;

import com.this0.headline.pojo.dto.NewsDto;
import com.this0.headline.service.HeadlineService;
import com.this0.headline.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/portal")
@RestController
public class NewsPage {

    @Resource
    private HeadlineService headlineService;

    @PostMapping("/findNewsPage")
    public Result findNewsPage(@RequestBody NewsDto newsDto) {
        Result result = headlineService.findNewsPage(newsDto);
        return result;
    }
}
