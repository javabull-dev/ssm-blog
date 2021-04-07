package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.bean.ArticleTag;
import com.javabull.ssm.blog.bean.ArticleTagExample;

import java.util.List;
import java.util.Map;

import com.javabull.ssm.blog.bean.Tag;
import org.apache.ibatis.annotations.Param;

public interface ArticleTagMapper {
    long countByExample(ArticleTagExample example);

    int deleteByExample(ArticleTagExample example);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    List<ArticleTag> selectByExample(ArticleTagExample example);

    int updateByExampleSelective(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int updateByExample(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int insertBatch(@Param("map") Map<String, Object> map);

    int deleteTagRef(Integer articleId);

    List<Tag> getByArticleIdWithTags(Integer articleId);

    List<Article> getArticlesByTagId(Integer tagId);

    List<Article> selectSummaryArticleAndTags();

    List<Article> selectSummaryArticles(@Param("articleId") Integer articleId, @Param("size") Integer size);

    List<Tag> getTagsByArticleId(Integer articleId);
}