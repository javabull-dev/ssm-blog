package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.FriendLink;

import java.util.List;

public interface IFriendLinkService {
    List<FriendLink> getAll();

    FriendLink getOne(Integer linkId);

    boolean exist(String linkName);

    int deleteOne(Integer linkId);

    int updateFriendLink(FriendLink friendLink);

    int saveFriendLink(FriendLink friendLink);

    List<FriendLink> getAllToShow();
}
