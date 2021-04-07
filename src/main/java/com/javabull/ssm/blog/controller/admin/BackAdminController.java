package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Article;
import com.javabull.ssm.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class BackAdminController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping("/logout")
    public String logout() {
        return "redirect:/goto";
    }

    @RequestMapping(value = {"/", "", "/index"})
    public String toMainPage(Map<String, Object> map) {
        List<Article> articleList = articleService.getLatestArticle(5);
        map.put("articleList", articleList);
        return "Admin/index";
    }
}
