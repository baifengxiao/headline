package com.this0.headline.pojo.vo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NewsVo implements Serializable {

    private Integer hid;

    private String title;

    private Integer type;

    private Integer pageViews;

    private Integer pastHours;

    private Integer publisher;

}