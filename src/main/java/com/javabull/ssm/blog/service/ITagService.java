package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Tag;
import com.javabull.ssm.blog.entity.TagWarp;

import java.util.List;

public interface ITagService {
    List<Tag> getTags();

    List<TagWarp> getAllTagWarp();

    int saveTag(Tag tag);

    boolean exist(String tagContent);

    Tag get(Integer tagId);

    int updateTag(Tag tag);
}
