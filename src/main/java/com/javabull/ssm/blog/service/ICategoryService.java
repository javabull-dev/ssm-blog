package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Category;
import com.javabull.ssm.blog.entity.CategoryParam;

import java.util.List;

public interface ICategoryService {
    /**
     * @return
     */
    List<Category> getAll();

    /**
     * @param categoryId
     */
    void deleteOneCategory(Integer categoryId);

    /**
     * @param categoryId
     * @return
     */
    Category getCategoryById(Integer categoryId);

    /**
     * @return
     */
    List<CategoryParam> getAllCategoryCount();

    /**
     * @param category
     * @return
     */
    int updateOneCategory(Category category);

    /**
     * @param categoryName
     * @return
     */
    boolean exist(String categoryName);

    /**
     * @param category
     * @return
     */
    int saveCategory(Category category);

    /**
     * @param categoryId
     * @return
     */
    boolean hasArticleAssocation(Integer categoryId);
}
