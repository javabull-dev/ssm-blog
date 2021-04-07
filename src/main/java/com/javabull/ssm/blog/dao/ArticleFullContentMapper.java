package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.entity.ArticleParam;
import org.apache.ibatis.annotations.Insert;

public interface ArticleFullContentMapper {
    @Insert("INSERT INTO tb_article_full_content(content_id,article_id,article_content)  " +
            "values(#{contentId,jdbcType=INTEGER},#{articleId,jdbcType=INTEGER},#{articleContent,jdbcType=LONGVARCHAR})")
    int insert(ArticleParam articleParam);


}
