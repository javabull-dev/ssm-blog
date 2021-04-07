package com.javabull.ssm.blog.bean;

import java.io.Serializable;

public class ArticleTag implements Serializable {
    private Integer articleId;

    private Integer tagId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}