package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.User;
import com.javabull.ssm.blog.bean.UserExample;

import java.util.List;

import com.javabull.ssm.blog.entity.UserTo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserTo> selectAll();

    User selectSelectiveWithReturnSelective(@Param("user") User user, @Param("example") UserExample example);
}