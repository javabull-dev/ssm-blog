package com.javabull.ssm.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.bean.Category;
import com.javabull.ssm.blog.bean.Tag;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.service.IArticleService;
import com.javabull.ssm.blog.service.ICategoryService;
import com.javabull.ssm.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author javabull
 */
@Controller
@RequestMapping("/admin/article")
public class BackArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ITagService tagService;

    @Autowired
    private ICategoryService categoryService;

    /**
     * 获取所有文章
     *
     * @param index
     * @param map
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allArticlePage(@RequestParam(value = "index", defaultValue = "1") Integer index,
                                 Map<String, Object> map) {
        Integer pageSize = 10;
        PageInfo<Article> pageInfo = articleService.getArticlePages(index, pageSize);
        map.put("pageInfo", pageInfo);
        map.put("pageUrlPrefix", "/admin/article?index");
        return "Admin/Article/index";
    }

    /**
     * 跳转到修改文章的页面
     *
     * @param articleId
     * @param map
     * @return
     */
    @RequestMapping(value = "/edit/{articleId}", method = RequestMethod.GET)
    public String editArticlePage(@PathVariable("articleId") Integer articleId, Map<String, Object> map) {
        //获取文章
        Article article = articleService.getArticle(articleId);
        //获取所有分类和标签
        List<Tag> tags = tagService.getTags();
        List<Category> categories = categoryService.getAll();
        map.put("article", article);
        map.put("tags", tags);
        map.put("categories", categories);
        return "Admin/Article/edit";
    }

    /**
     * 文章修改后，提交
     * ajax, 页面不跳转
     *
     * @Return
     */
    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editArticleSubmit(Article article, Integer articleParentCategoryId,
                                 Integer[] articleTagIds, String copyArticleTitle) {
        //文章是否和之前文章名相同
        if (!copyArticleTitle.equals(article.getArticleTitle().trim())) {
            //查看文章名是否已存在
            boolean flag = articleService.exist(article.getArticleTitle());
            if (flag) {
                Msg msg = new Msg();
                msg.setCode(200);
                msg.setMsg("文章名已存在,请重新编辑!");
                return msg;
            }
        }
        try {
            articleService.update(article, articleParentCategoryId, articleTagIds);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 跳转到 添加文章 的页面
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String addArticlePage(Map<String, Object> map) {
        //读取所有的文章分类
        List<Category> categories = categoryService.getAll();
        //读取所有的文章标签
        List<Tag> tags = tagService.getTags();
        map.put("categories", categories);
        map.put("tags", tags);
        return "Admin/Article/insert";
    }

    /**
     * 执行插入文章
     *
     * @param article
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public Msg addArticleSubmit(Article article, Integer articleParentCategoryId, Integer[] articleTagIds) {
        //查看文章名是否已存在
        boolean flag = articleService.exist(article.getArticleTitle());
        if (flag) {
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("文章名已存在,请重新编辑!");
            return msg;
        }
        articleService.insertWithCategoryAndTag(article, articleParentCategoryId, articleTagIds);
        return Msg.success();
    }

    /**
     * 删除一篇文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/delete/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg deleteOneArticle(@PathVariable("articleId") Integer articleId) {
        try {
            articleService.deleteOneArticle(articleId);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/insertDraftSubmit", method = RequestMethod.POST)
    public String insertDraftSubmit(Article article) {
        articleService.saveDraft(article);
        return "redirect:/admin/index";
    }
}
