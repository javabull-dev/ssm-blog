package com.javabull.ssm.blog.test;

import com.github.pagehelper.PageInfo;
import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.entity.CategoryParam;
import com.javabull.ssm.blog.service.IArticleService;
import com.javabull.ssm.blog.service.ICategoryService;
import com.javabull.ssm.blog.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class ServiceTest {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void testArticleService01() {
        List<Article> latestArticle = articleService.getLatestArticle(5);
        System.out.println(latestArticle);
    }

    @Test
    public void testArticleService02() {
//        PageInfo<Article> articles = articleService.getSummaryArticles(1, 4);
//        System.out.println(articles);
    }

//    @Test
    public void testCategoryService() {
        List<CategoryParam> categoryCount = categoryService.getAllCategoryCount();
        System.out.println(categoryCount.get(0).getCategory());
    }

    @Test
    public void testarticleService02() {
        PageInfo<Article> pageInfo = articleService.getArticlesByTagId(6, 1, 10);
        System.out.println(pageInfo);
    }
}
