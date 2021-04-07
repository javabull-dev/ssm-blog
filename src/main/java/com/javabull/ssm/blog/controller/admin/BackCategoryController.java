package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Category;
import com.javabull.ssm.blog.entity.CategoryParam;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin/category")
@Controller
public class BackCategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<CategoryParam> allCategoryWarps = categoryService.getAllCategoryCount();
        map.put("allCategoryWarps", allCategoryWarps);
        return "Admin/Category/index";
    }

    @RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.GET)
    public String eidtPage(@PathVariable("categoryId") Integer categoryId, Map<String, Object> map) {
        List<CategoryParam> allCategoryWarps = categoryService.getAllCategoryCount();
        Category category = categoryService.getCategoryById(categoryId);
        map.put("allCategoryWarps", allCategoryWarps);
        map.put("category", category);
        return "Admin/Category/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(Category category) {
        try {
            categoryService.updateOneCategory(category);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.GET)
    public String delete(@PathVariable("categoryId") Integer categoryId) {
        //检查对应的categoryId是否存在文章关联
        boolean flag = categoryService.hasArticleAssocation(categoryId);
        if (!flag) {
            categoryService.deleteOneCategory(categoryId);
        }
        return "redirect:/admin/category";
    }

    @ResponseBody
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public Msg insertSubmit(Category category) {
        //查看是否已存在
        boolean flag = categoryService.exist(category.getCategoryName());
        if (flag) {
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("分类名已存在!");
            return msg;
        }
        categoryService.saveCategory(category);
        return Msg.success();
    }
}