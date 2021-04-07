package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.bean.ArticleExample;

import java.util.List;

import com.javabull.ssm.blog.entity.ArticleParam;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectByExampleReturnSelective(@Param("article") Article article,
                                                 @Param("example") ArticleExample example,
                                                 @Param("retCount") Integer retCount);

    void updateReadAmount(Integer articleId);

    Article selectByArticleId(Integer articleId);

    ArticleParam selectArticleParam(Integer index);

    Integer selectFirstArticleId();
}