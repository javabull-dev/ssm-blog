package com.javabull.ssm.blog.bean;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Screen implements Serializable {
    private Integer screenId;

    private String screenImgName;

    private String screenImgUrl;

    private Date screenCreateTime;

    private Date screenUpdateTime;

    private Integer screenStatus;

    private Integer screenOrder;

    private Integer articleId;

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public String getScreenImgName() {
        return screenImgName;
    }

    public void setScreenImgName(String screenImgName) {
        this.screenImgName = screenImgName == null ? null : screenImgName.trim();
    }

    public String getScreenImgUrl() {
        return screenImgUrl;
    }

    public void setScreenImgUrl(String screenImgUrl) {
        this.screenImgUrl = screenImgUrl == null ? null : screenImgUrl.trim();
    }

    public Date getScreenCreateTime() {
        return screenCreateTime;
    }

    public void setScreenCreateTime(Date screenCreateTime) {
        this.screenCreateTime = screenCreateTime;
    }

    public Date getScreenUpdateTime() {
        return screenUpdateTime;
    }

    public void setScreenUpdateTime(Date screenUpdateTime) {
        this.screenUpdateTime = screenUpdateTime;
    }

    public Integer getScreenStatus() {
        return screenStatus;
    }

    public void setScreenStatus(Integer screenStatus) {
        this.screenStatus = screenStatus;
    }

    public Integer getScreenOrder() {
        return screenOrder;
    }

    public void setScreenOrder(Integer screenOrder) {
        this.screenOrder = screenOrder;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}