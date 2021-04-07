package com.javabull.ssm.blog.dao;

import com.javabull.ssm.blog.bean.FriendLink;
import com.javabull.ssm.blog.bean.FriendLinkExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FriendLinkMapper {
    long countByExample(FriendLinkExample example);

    int deleteByExample(FriendLinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(FriendLink record);

    int insertSelective(FriendLink record);

    List<FriendLink> selectByExample(FriendLinkExample example);

    FriendLink selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    int updateByExample(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    int updateByPrimaryKeySelective(FriendLink record);

    int updateByPrimaryKey(FriendLink record);

    List<FriendLink> selectByExampleWithSelectiveReturn(@Param("friendLink") FriendLink friendLink,
                                                        @Param("example") FriendLinkExample friendLinkExample);
}