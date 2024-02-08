package com.this0.headline.controller;


import com.this0.headline.pojo.Headline;
import com.this0.headline.service.HeadlineService;
import com.this0.headline.util.JwtHelper;
import com.this0.headline.util.Result;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/headline")
public class HeadLineController {

    @Resource
    private HeadlineService headlineService;


    @PostMapping("/publish")
    public Result publish(@RequestHeader String token, @RequestBody Headline headline) {

        Result  result =headlineService.publish(token,headline);


            return Result.ok(result);
    }

    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(String hid){
        Result result= headlineService.findHeadlineByHid(hid);
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody Headline headline){
        Result result= headlineService.updateHeadline(headline);
        return Result.ok(result);
    }

    @PostMapping("/removeByHid")
    public Result removeByHid(String hid ) {
        Result result = headlineService.removeByHid(hid);
        return Result.ok(result);
    }
}


