package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.FriendLink;
import com.javabull.ssm.blog.bean.FriendLinkExample;
import com.javabull.ssm.blog.dao.FriendLinkMapper;
import com.javabull.ssm.blog.service.IFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FriendLinkService implements IFriendLinkService {

    @Autowired
    private FriendLinkMapper friendLinkMapper;

    public List<FriendLink> getAll() {
        FriendLinkExample friendLinkExample = new FriendLinkExample();
        friendLinkExample.setOrderByClause("`tb_friend_link`.link_order desc");
        List<FriendLink> friendLinks = friendLinkMapper.selectByExample(friendLinkExample);
        return friendLinks;
    }

    public FriendLink getOne(Integer linkId) {
        FriendLink friendLink = friendLinkMapper.selectByPrimaryKey(linkId);
        return friendLink;
    }

    public boolean exist(String linkName) {
        FriendLinkExample friendLinkExample = new FriendLinkExample();
        FriendLinkExample.Criteria criteria = friendLinkExample.createCriteria();
        criteria.andLinkNameEqualTo(linkName);
        long count = friendLinkMapper.countByExample(friendLinkExample);
        return count >= 1;
    }

    public int deleteOne(Integer linkId) {
        return friendLinkMapper.deleteByPrimaryKey(linkId);
    }

    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkMapper.updateByPrimaryKeySelective(friendLink);
    }

    public int saveFriendLink(FriendLink friendLink) {
        friendLink.setLinkCreateTime(new Date());
        return friendLinkMapper.insert(friendLink);
    }

    @Override
    public List<FriendLink> getAllToShow() {
        FriendLink friendLink = new FriendLink();
        friendLink.setLinkName("");
        friendLink.setLinkUrl("");
        FriendLinkExample friendLinkExample = new FriendLinkExample();
        friendLinkExample.setOrderByClause("tb_link.link_order desc");
        return friendLinkMapper.selectByExampleWithSelectiveReturn(friendLink, friendLinkExample);
    }
}
