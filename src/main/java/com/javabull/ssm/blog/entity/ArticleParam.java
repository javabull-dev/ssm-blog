package com.javabull.ssm.blog.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class ArticleParam {
    private Integer contentId;
    private Integer articleId;
    private String articleContent;
}
