package com.javabull.ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javabull.ssm.blog.bean.*;
import com.javabull.ssm.blog.dao.ArticleCategoryMapper;
import com.javabull.ssm.blog.dao.ArticleMapper;
import com.javabull.ssm.blog.dao.ArticleParamMapper;
import com.javabull.ssm.blog.dao.ArticleTagMapper;
import com.javabull.ssm.blog.lucene.ArticleIndexer;
import com.javabull.ssm.blog.service.IArticleService;
import com.javabull.ssm.blog.util.MyUtil;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService implements IArticleService {

    private final ArticleMapper articleMapper;

    private final ArticleCategoryMapper articleCategoryMapper;

    private final ArticleTagMapper articleTagMapper;

    private final ArticleIndexer articleIndexer;

    private final ArticleParamMapper articleParamMapper;

    /**
     * spring自动传入参数
     * @param articleMapper
     * @param articleCategoryMapper
     * @param articleTagMapper
     * @param articleIndexer
     * @param articleParamMapper
     */
    public ArticleService(ArticleMapper articleMapper, ArticleCategoryMapper articleCategoryMapper,
                          ArticleTagMapper articleTagMapper, ArticleIndexer articleIndexer, ArticleParamMapper articleParamMapper) {
        this.articleMapper = articleMapper;
        this.articleCategoryMapper = articleCategoryMapper;
        this.articleTagMapper = articleTagMapper;
        this.articleIndexer = articleIndexer;
        this.articleParamMapper = articleParamMapper;
    }

    /**
     * 根据id获取文章
     *
     * @param articleId
     * @return
     */
    public Article getArticle(Integer articleId) {
        Article article = articleMapper.selectByArticleId(articleId);
        String s = articleParamMapper.selectContentByArticleId(articleId);
        article.setArticleContent(s);
        return article;
    }

    /**
     * 添加文章，同时添加索引
     *
     * @param article
     * @param articleParentCategoryId
     * @param articleTagIds
     */
    public void insertWithCategoryAndTag(Article article, Integer articleParentCategoryId, Integer[] articleTagIds) {
        article.setArticleReadAmount(0);
        Date date = new Date();
        article.setArticleCreateTime(date);
        article.setArticleUpdateTime(date);
        article.setArticleSummary(MyUtil.createSummaryText(article.getArticleContent()));
        articleMapper.insert(article);
        //添加索引
        articleIndexer.addIndex(article);
        Integer articleId = article.getArticleId();
        articleCategoryMapper.insert(new ArticleCategory(articleId, articleParentCategoryId));
        //多个标签
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("articleId", articleId);
        map.put("articleTagIds", articleTagIds);
        articleTagMapper.insertBatch(map);
    }

    /**
     * 获取所有文章和文章所对应的分类
     *
     * @return
     */
    public PageInfo<Article> getArticlePages(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> list = articleCategoryMapper.getArticlesWithCategory();
        return new PageInfo<>(list);
    }

    /**
     * 删除文章，标签，同时删除索引
     *
     * @param articleId
     */
    public void deleteOneArticle(Integer articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
        //删除索引
        articleIndexer.deleteIndex(String.valueOf(articleId));
        articleTagMapper.deleteTagRef(articleId);
        articleCategoryMapper.deleteCategoryRef(articleId);
    }

    /**
     * 更新文章，同时更新索引
     *
     * @param article
     * @param articleParentCategoryId
     * @param articleTagIds
     */
    public void update(Article article, Integer articleParentCategoryId, Integer[] articleTagIds) {
        Integer articleId = article.getArticleId();
        article.setArticleUpdateTime(new Date());
        articleMapper.updateByPrimaryKeySelective(article);
        //更新索引
        articleIndexer.updateIndex(article);
        articleCategoryMapper.updateByArticleId(articleId, articleParentCategoryId);
        //先删除原来的标签，后添加新的标签
        articleTagMapper.deleteTagRef(articleId);
        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);
        map.put("articleTagIds", articleTagIds);
        articleTagMapper.insertBatch(map);
    }

    /**
     * 检查文章名是否存在
     *
     * @param articleTitle
     * @return
     */
    public boolean exist(String articleTitle) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleTitleEqualTo(articleTitle);
        long count = articleMapper.countByExample(articleExample);
        return count >= 1;
    }

    /**
     * @param i
     * @return
     */
    public List<Article> getLatestArticle(int i) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause("tb_article.article_create_time desc");
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        //不获取草稿
        criteria.andArticleStatusNotEqualTo(0);
        Article article = new Article();
        article.setArticleId(1);
        article.setArticleTitle("");
        article.setArticleCreateTime(new Date());
        List<Article> articles = articleMapper.selectByExampleReturnSelective(article, articleExample, i);
        return articles;
    }

    /**
     * @param article
     * @return
     */
    public int saveDraft(Article article) {
        Date date = new Date();
        article.setArticleUpdateTime(date);
        article.setArticleCreateTime(date);
        article.setArticleStatus(0);
        return articleMapper.insert(article);
    }

    /**
     * 读取时间，标签，阅读人数
     *
     * @return
     */
    public List<Article> getSummaryArticles(Integer articleId, Integer size) {
        List<Article> list = articleTagMapper.selectSummaryArticles(articleId, size);
        for (Article article : list) {
            List<Tag> tags = articleTagMapper.getTagsByArticleId(article.getArticleId());
            article.setTags(tags);
        }
        return list;
    }

    /**
     * 根据分类id 获取文章，并且要查出对应的分类
     *
     * @param id
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageInfo<Article> getArticlesById(Integer id, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> articles = articleCategoryMapper.getArticlesByCategoryId(id);
        return new PageInfo<>(articles);
    }

    /**
     * 根据标签id 获取文章，并且要查出文章所对应的标签
     *
     * @param tagId
     * @param index
     * @param i
     * @return
     */
    @Override
    public PageInfo<Article> getArticlesByTagId(Integer tagId, Integer index, int i) {
        PageHelper.startPage(index, i);
        List<Article> articles = articleTagMapper.getArticlesByTagId(tagId);
        return new PageInfo<>(articles);
    }

    @Override
    public List<Article> getAllArticleWithOther() {
        Article articleParam = new Article();
        articleParam.setArticleId(1);
        articleParam.setArticleTitle("");
        articleParam.setArticleCreateTime(new Date());
        return articleMapper.selectByExampleReturnSelective(articleParam, null, null);
    }

    @Override
    public void inclementReadAmount(Integer articleId) {
        articleMapper.updateReadAmount(articleId);
    }

    @Override
    public Integer getFirstArticleId() {
        return articleMapper.selectFirstArticleId();
    }
}
