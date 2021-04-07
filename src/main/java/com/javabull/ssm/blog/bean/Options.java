package com.javabull.ssm.blog.bean;

import java.io.Serializable;
import java.util.Date;

public class Options implements Serializable {
    private Integer optionId;

    private String optionTitle;

    private String optionSiteDescrption;

    private String optionPageDescrption;

    private String optionMetaKeyword;

    private Date optionUpdateTime;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionTitle() {
        return optionTitle;
    }

    public void setOptionTitle(String optionTitle) {
        this.optionTitle = optionTitle == null ? null : optionTitle.trim();
    }

    public String getOptionSiteDescrption() {
        return optionSiteDescrption;
    }

    public void setOptionSiteDescrption(String optionSiteDescrption) {
        this.optionSiteDescrption = optionSiteDescrption == null ? null : optionSiteDescrption.trim();
    }

    public String getOptionPageDescrption() {
        return optionPageDescrption;
    }

    public void setOptionPageDescrption(String optionPageDescrption) {
        this.optionPageDescrption = optionPageDescrption == null ? null : optionPageDescrption.trim();
    }

    public String getOptionMetaKeyword() {
        return optionMetaKeyword;
    }

    public void setOptionMetaKeyword(String optionMetaKeyword) {
        this.optionMetaKeyword = optionMetaKeyword == null ? null : optionMetaKeyword.trim();
    }

    public Date getOptionUpdateTime() {
        return optionUpdateTime;
    }

    public void setOptionUpdateTime(Date optionUpdateTime) {
        this.optionUpdateTime = optionUpdateTime;
    }
}