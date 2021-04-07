package com.javabull.ssm.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ScreenParam implements Serializable {

    private Integer screenId;

    private String screenImgName;

    private String screenImgUrl;

    private Date screenCreateTime;

    private Date screenUpdateTime;

    private Integer screenStatus;

    private Integer screenOrder;

    private Integer articleId;

    private String aritcleTitle;
}
