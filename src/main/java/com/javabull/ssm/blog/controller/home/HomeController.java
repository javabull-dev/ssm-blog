package com.javabull.ssm.blog.controller.home;

import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.javabull.ssm.blog.bean.*;
import com.javabull.ssm.blog.entity.CategoryParam;
import com.javabull.ssm.blog.entity.LucenePageInfo;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.lucene.ArticleIndexer;
import com.javabull.ssm.blog.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class HomeController {

    private final IUserService userService;

    private final IArticleService articleService;

    private final ITagService tagService;

    private final ILinkService linkService;

    private final IFriendLinkService friendLinkService;

    private final ICategoryService categoryService;

    private final IOptionsService optionsService;

    private final ArticleIndexer articleIndexer;

    private final RedisTemplate<String, Object> redisTemplate;

    public HomeController(IUserService userService, IArticleService articleService, ITagService tagService,
                          ILinkService linkService, IFriendLinkService friendLinkService,
                          ICategoryService categoryService, IOptionsService optionsService,
                          ArticleIndexer articleIndexer,
                          RedisTemplate<String, Object> redisTemplate) {
        this.userService = userService;
        this.articleService = articleService;
        this.tagService = tagService;
        this.linkService = linkService;
        this.friendLinkService = friendLinkService;
        this.categoryService = categoryService;
        this.optionsService = optionsService;
        this.articleIndexer = articleIndexer;
        this.redisTemplate = redisTemplate;
    }

    /**
     * @param map
     */
    @SuppressWarnings("unchecked")
    private void commonOption(Map<String, Object> map) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Options option = (Options) opsForValue.get("option");
        if (option == null) {
            option = optionsService.getOption();
            opsForValue.set("option", option, 10, TimeUnit.MINUTES);
        }
        List<Tag> tags = (List<Tag>) opsForValue.get("tags");
        if (tags == null) {
            tags = tagService.getTags();
            opsForValue.set("tags", tags, 10, TimeUnit.MINUTES);
        }
        List<CategoryParam> categoryParams = (List<CategoryParam>) opsForValue.get("categoryParams");
        if (categoryParams == null) {
            categoryParams = categoryService.getAllCategoryCount();
            opsForValue.set("categoryParams", categoryParams, 10, TimeUnit.MINUTES);
        }
        List<Link> links = (List<Link>) opsForValue.get("links");
        if (links == null) {
            links = linkService.getAllToShow();
            opsForValue.set("links", links, 10, TimeUnit.MINUTES);
        }
        List<FriendLink> friendLinks = (List<FriendLink>) opsForValue.get("friendLinks");
        if (friendLinks == null) {
            friendLinks = friendLinkService.getAllToShow();
            opsForValue.set("friendLinks", friendLinks, 10, TimeUnit.MINUTES);
        }
        map.put("option", option);
        map.put("tags", tags);
        map.put("categoryParams", categoryParams);
        map.put("links", links);
        map.put("friendLinks", friendLinks);
    }

    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String homePage(Map<String, Object> map) {
        try {
            commonOption(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("pageToken", "home");
        return "Home/Page/home";
    }

    /**
     * 首页文章条目的获取
     *
     * @param articleId 前台页面条目列表的最后一个文章的id
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/home/getArticle", method = RequestMethod.POST)
    @ResponseBody
    public Msg getArticle(@RequestParam(value = "articleId", defaultValue = "1", required = false) Integer articleId) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        // article-block:文章块
        if (articleId == -1) {
            articleId = articleService.getFirstArticleId();
        }
        if (articleId == null) {
            //数据库中没有文章
            return Msg.fail();
        }
        List<Article> articles = (List<Article>) opsForValue.get("article-block" + articleId);
        if (articles == null) {
            //以4篇文章为一个文章块
            try {
                articles = articleService.getSummaryArticles(articleId, 4);
                opsForValue.set("article-block" + articleId, articles, 10, TimeUnit.MINUTES);
            } catch (Exception e) {
                return Msg.fail();
            }
        }
        Msg msg = Msg.success();
        msg.getExtend().put("articles", articles);
        return msg;
    }

    /**
     * 文章归档
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/achieve", method = RequestMethod.GET)
    public String achieve(Map<String, Object> map) {
        try {
            commonOption(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        List<Article> articles = (List<Article>) opsForValue.get("articles");
        if (articles == null) {
            articles = articleService.getAllArticleWithOther();
            opsForValue.set("articles", articles, 10, TimeUnit.MINUTES);
        }
        map.put("articles", articles);
        map.put("pageToken", "achieve");
        return "Home/Page/achieve";
    }

    /**
     * 文章显示
     *
     * @return
     */
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public String article(Map<String, Object> map, @PathVariable("articleId") Integer articleId) {
        long startTime = System.currentTimeMillis();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        Article article = (Article) opsForValue.get("article" + articleId);
        if (article == null) {
            article = articleService.getArticle(articleId);
            opsForValue.set("article" + articleId, article, 10, TimeUnit.MINUTES);
        }
        //阅读数量自增
        articleService.inclementReadAmount(articleId);
        Options option = (Options) opsForValue.get("option");
        if (option == null) {
            option = optionsService.getOption();
            opsForValue.set("option", option, 10, TimeUnit.MINUTES);
        }
        map.put("option", option);
        map.put("article", article);
        map.put("pageToken", "article");
        long endTime = System.currentTimeMillis();
        System.out.println("endTime - startTime = " + (endTime - startTime) / 1000);
        return "Home/Page/article";
    }

    /**
     * about页面
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Map<String, Object> map) {
        map.put("pageToken", "about");
        return "Home/Page/about";
    }

    /**
     * 站内全文搜索
     */
    @RequestMapping(value = "/home/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String serachSubmit(@RequestParam(value = "keyword") String key, Map<String, Object> map,
                               @RequestParam(value = "pageIndex", defaultValue = "1", required = false) Integer pageIndex) {
        String s = HtmlUtil.cleanHtmlTag(key);
        LucenePageInfo<Article> lucenePageInfo = articleIndexer.searchArticle(s, pageIndex, 5);
        try {
            commonOption(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("lucenePageInfo", lucenePageInfo);
        map.put("keyword", key);
        return "Home/Page/search";
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public String categoryPage(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map) {
        try {
            commonOption(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("categoryId", categoryId);
        return "Home/Page/category";
    }

    @SuppressWarnings("unchecked")
    @ResponseBody
    @RequestMapping(value = "/category/{categoryId}/getArticle", method = RequestMethod.POST)
    public Msg categoryGetArticle(@PathVariable("categoryId") Integer categoryId, @RequestParam(value = "index",
            required = false, defaultValue = "1") Integer index, Map<String, Object> map) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        PageInfo<Article> pageInfo = (PageInfo<Article>) opsForValue.get("category" + categoryId + "-pageInfo" + index);
        if (pageInfo == null) {
            pageInfo = articleService.getArticlesById(categoryId, index, 4);
            opsForValue.set("category" + categoryId + "-pageInfo" + index, pageInfo, 10, TimeUnit.MINUTES);
        }
        map.put("categoryId", categoryId);
        map.put("pageInfo", pageInfo);
        Msg msg = Msg.success();
        msg.getExtend().put("pageInfo", pageInfo);
        return msg;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    public String tagPage(@PathVariable("tagId") Integer tagId, @RequestParam(value = "index",
            required = false, defaultValue = "1") Integer index, Map<String, Object> map) {
        try {
            commonOption(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        PageInfo<Article> pageInfo = (PageInfo<Article>) opsForValue.get("tag-" + tagId + "-pageInfo" + index);
        if (pageInfo == null) {
            pageInfo = articleService.getArticlesByTagId(tagId, index, 4);
            opsForValue.set("tag-" + tagId + "-pageInfo" + index, pageInfo, 10, TimeUnit.MINUTES);
        }
        map.put("pageInfo", pageInfo);
        map.put("tagId", tagId);
        return "Home/Page/tag";
    }

    /**
     * 登入
     *
     * @return
     */
    @RequestMapping(value = "/goto", method = RequestMethod.GET)
    public String login() {
        return "Home/Page/login";
    }

    /**
     * @param user
     * @param map
     * @return
     */
    @RequestMapping(value = "/goto", method = RequestMethod.POST)
    public String check(User user, Map<String, String> map, HttpServletRequest httpServletRequest) {
        Subject subject = SecurityUtils.getSubject();
        String userName = user.getUserName();
        String userPassword = user.getUserPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        token.setRememberMe(true);
        try {
            subject.login(token);
            HttpSession session = httpServletRequest.getSession();
            //10*60 s, 即10分钟
            session.setMaxInactiveInterval(10 * 60);
            //将userName，userAvatarUrl放入session
            String userAvatarUrl = userService.getUserAvatarUrl(user.getUserName());
            session.setAttribute("userName", userName);
            session.setAttribute("userAvatarUrl", userAvatarUrl);
            //获取访问ip
            String ip = httpServletRequest.getRemoteHost();
            userService.updateLoginTimeAndIP(new Date(), ip, userName);
            return "redirect:/admin/index";
        } catch (AuthenticationException e) {
            map.put("errorMsg", "用户名或密码错误");
            map.put("userName", user.getUserName());
            token.clear();
            return "/Home/Page/login";
        }
    }
}

