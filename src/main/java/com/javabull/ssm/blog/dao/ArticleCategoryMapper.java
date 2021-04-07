package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.bean.ArticleCategory;
import com.javabull.ssm.blog.bean.ArticleCategoryExample;
import com.javabull.ssm.blog.bean.Category;
import com.javabull.ssm.blog.entity.CategoryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCategoryMapper {
    long countByExample(ArticleCategoryExample example);

    int deleteByExample(ArticleCategoryExample example);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    List<ArticleCategory> selectByExample(ArticleCategoryExample example);

    int updateByExampleSelective(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByExample(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    Category getByArticleIdWithCategorys(Integer articleId);

    List<Article> getArticlesByCategoryId(Integer categoryId);

    int deleteCategoryRef(Integer articleId);

    int updateByArticleId(@Param("articleId") Integer articleId, @Param("categoryId") Integer articleParentCategoryId);

    List<Article> getArticlesWithCategory();

    List<CategoryParam> selectAllCategoryArticleCount();
}