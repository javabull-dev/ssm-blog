package com.javabull.ssm.blog.dao;

import org.apache.ibatis.annotations.Param;

public interface ArticleParamMapper {

    String selectContentByArticleId(@Param("articleId") Integer articleId);
}
