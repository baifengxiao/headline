package com.this0.headline.pojo.dto;

import lombok.Data;

@Data
public class NewsDto {
    private String keyWords;
    private Integer type;
    private Integer pageNum;
    private Integer pageSize;
}
