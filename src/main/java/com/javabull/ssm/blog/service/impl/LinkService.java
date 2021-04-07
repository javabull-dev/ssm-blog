package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Link;
import com.javabull.ssm.blog.bean.LinkExample;
import com.javabull.ssm.blog.dao.LinkMapper;
import com.javabull.ssm.blog.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private LinkMapper linkMapper;

    public List<Link> getAll() {
        LinkExample linkExample = new LinkExample();
        linkExample.setOrderByClause("tb_link.link_order asc");
        return linkMapper.selectByExample(linkExample);
    }

    public boolean existTitle(String title) {
        LinkExample linkExample = new LinkExample();
        LinkExample.Criteria criteria = linkExample.createCriteria();
        criteria.andLinkTitleEqualTo(title);
        long l = linkMapper.countByExample(linkExample);
        return l >= 1;
    }

    public int saveOne(Link link) {
        Date date = new Date();
        link.setLinkCreateTime(date);
        link.setLinkUpdateTime(date);
        return linkMapper.insert(link);
    }

    public int delete(Integer linkId) {
        return linkMapper.deleteByPrimaryKey(linkId);
    }

    public Link getOne(Integer linkId) {
        return linkMapper.selectByPrimaryKey(linkId);
    }

    public int updateOne(Link link) {
        link.setLinkUpdateTime(new Date());
        return linkMapper.updateByPrimaryKeySelective(link);
    }

    /**
     * 前台展示的link
     *
     * @return
     */
    @Override
    public List<Link> getAllToShow() {
        Link link = new Link();
        link.setLinkTitle("");
        link.setLinkAvatarUrl("");
        link.setLinkUrl("");
        LinkExample linkExample = new LinkExample();
        linkExample.setOrderByClause("tb_link.link_order asc");
        LinkExample.Criteria criteria = linkExample.createCriteria();
        criteria.andLinkStatusNotEqualTo(0);
        return linkMapper.selectByExampleWithSelectiveReturn(link, linkExample);
    }
}
