package com.javabull.ssm.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategory implements Serializable {
    private Integer articleId;
    private Integer categoryId;
}