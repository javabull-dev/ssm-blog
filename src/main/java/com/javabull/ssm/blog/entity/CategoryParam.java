package com.javabull.ssm.blog.entity;

import com.javabull.ssm.blog.bean.Category;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryParam implements Serializable {
    private Category category;
    private Integer articleCount;
}
