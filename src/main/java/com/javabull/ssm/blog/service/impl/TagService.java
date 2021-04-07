package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Tag;
import com.javabull.ssm.blog.bean.TagExample;
import com.javabull.ssm.blog.dao.TagMapper;
import com.javabull.ssm.blog.entity.TagWarp;
import com.javabull.ssm.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TagService implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    public List<Tag> getTags() {
        List<Tag> tags = tagMapper.selectByExample(null);
        return tags;
    }

    public List<TagWarp> getAllTagWarp() {
        List<Tag> tags = tagMapper.selectByExample(null);
        List<TagWarp> tagWarps = new ArrayList<TagWarp>();
        for (Tag tag : tags) {
            Integer tagId = tag.getTagId();
            int count = tagMapper.countArticleByTagId(tagId);
            TagWarp tagWarp = new TagWarp();
            tagWarp.setArticleCount(count);
            tagWarp.setTag(tag);
            tagWarps.add(tagWarp);
        }
        return tagWarps;
    }

    public int saveTag(Tag tag) {
        Date date = new Date();
        tag.setTagCreateTime(date);
        tag.setTagUpdateTime(date);
        return tagMapper.insert(tag);
    }

    public boolean exist(String tagContent) {
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagContentEqualTo(tagContent);
        long count = tagMapper.countByExample(tagExample);
        return count>=1;
    }

    public Tag get(Integer tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }

    public int updateTag(Tag tag) {
        //更新 修改时间
        tag.setTagUpdateTime(new Date());
        return tagMapper.updateByPrimaryKeySelective(tag);
    }
}
