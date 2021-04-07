package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Link;

import java.util.List;

public interface ILinkService {
    List<Link> getAll();

    boolean existTitle(String title);

    int saveOne(Link link);

    int delete(Integer linkId);

    Link getOne(Integer linkId);

    int updateOne(Link link);

    List<Link> getAllToShow();
}
