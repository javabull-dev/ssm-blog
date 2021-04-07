package com.javabull.ssm.blog.service;

import com.github.pagehelper.PageInfo;
import com.javabull.ssm.blog.bean.Article;

import java.util.List;

public interface IArticleService {
    /**
     * @param articleId
     * @return
     */
    Article getArticle(Integer articleId);

    /**
     * @param article
     * @param articleParentCategoryId
     * @param articleTagIds
     */
    void insertWithCategoryAndTag(Article article, Integer articleParentCategoryId, Integer[] articleTagIds);


    /**
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<Article> getArticlePages(Integer pageIndex, Integer pageSize);

    /**
     * @param articleId
     */
    void deleteOneArticle(Integer articleId);

    /**
     * @param article
     * @param articleParentCategoryId
     * @param articleTagIds
     */
    void update(Article article, Integer articleParentCategoryId, Integer[] articleTagIds);

    /**
     * @param articleTitle
     * @return
     */
    boolean exist(String articleTitle);

    /**
     * @param i
     * @return
     */
    List<Article> getLatestArticle(int i);

    /**
     * @param article
     * @return
     */
    int saveDraft(Article article);

    /**
     * @return
     */
    List<Article> getSummaryArticles(Integer articleId, Integer size);

    /**
     * @param id
     * @return
     */
    PageInfo<Article> getArticlesById(Integer id, Integer pageIndex, Integer pageSize);

    /**
     * @param tagId
     * @param index
     * @param i
     * @return
     */
    PageInfo<Article> getArticlesByTagId(Integer tagId, Integer index, int i);

    /**
     * @return
     */
    List<Article> getAllArticleWithOther();

    /**
     * 增加阅读数量
     */
    void inclementReadAmount(Integer articleId);

    /**
     * 获取数据库中第一篇文章的id
     * @return
     */
    Integer getFirstArticleId();
}
