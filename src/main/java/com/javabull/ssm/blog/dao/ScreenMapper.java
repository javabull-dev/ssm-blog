package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.Screen;
import com.javabull.ssm.blog.bean.ScreenExample;
import java.util.List;

import com.javabull.ssm.blog.entity.ScreenParam;
import org.apache.ibatis.annotations.Param;

public interface ScreenMapper {
    long countByExample(ScreenExample example);

    int deleteByExample(ScreenExample example);

    int deleteByPrimaryKey(Integer screenId);

    int insert(Screen record);

    int insertSelective(Screen record);

    List<Screen> selectByExample(ScreenExample example);

    Screen selectByPrimaryKey(Integer screenId);

    int updateByExampleSelective(@Param("record") Screen record, @Param("example") ScreenExample example);

    int updateByExample(@Param("record") Screen record, @Param("example") ScreenExample example);

    int updateByPrimaryKeySelective(Screen record);

    int updateByPrimaryKey(Screen record);

    ScreenParam selectByScreenIdWithArticleId(Integer screenId);

    List<ScreenParam> selectScreensWithArticleId();
}