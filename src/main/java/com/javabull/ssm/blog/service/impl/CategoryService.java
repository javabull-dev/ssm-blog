package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Category;
import com.javabull.ssm.blog.bean.CategoryExample;
import com.javabull.ssm.blog.dao.ArticleCategoryMapper;
import com.javabull.ssm.blog.dao.CategoryMapper;
import com.javabull.ssm.blog.entity.CategoryParam;
import com.javabull.ssm.blog.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryMapper categoryMapper;

    private final ArticleCategoryMapper articleCategoryMapper;

    public CategoryService(CategoryMapper categoryMapper, ArticleCategoryMapper articleCategoryMapper) {
        this.categoryMapper = categoryMapper;
        this.articleCategoryMapper = articleCategoryMapper;
    }

    public List<Category> getAll() {
        List<Category> categories = categoryMapper.selectByExample(null);
        return categories;
    }

    public void deleteOneCategory(Integer categoryId) {
        int i = categoryMapper.deleteByPrimaryKey(categoryId);
    }

    public Category getCategoryById(Integer categoryId) {
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        return category;
    }

    public List<CategoryParam> getAllCategoryCount() {
        return articleCategoryMapper.selectAllCategoryArticleCount();
    }

    public int updateOneCategory(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public boolean exist(String categoryName) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andCategoryNameEqualTo(categoryName);
        long count = categoryMapper.countByExample(categoryExample);
        return count >= 1;
    }

    public int saveCategory(Category category) {
        Date date = new Date();
        category.setCategoryCreateTime(date);
        category.setCategoryUpdateTime(date);
        return categoryMapper.insert(category);
    }

    public boolean hasArticleAssocation(Integer categoryId) {
        long count = categoryMapper.countByCategoryIdWithArticleAssocation(categoryId);
        return count >= 1;
    }
}
