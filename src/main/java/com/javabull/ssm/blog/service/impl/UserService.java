package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.User;
import com.javabull.ssm.blog.bean.UserExample;
import com.javabull.ssm.blog.dao.ArticleMapper;
import com.javabull.ssm.blog.dao.UserMapper;
import com.javabull.ssm.blog.entity.UserTo;
import com.javabull.ssm.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    private ArticleMapper articleMapper;


    public User getByAccount(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<com.javabull.ssm.blog.bean.User> users = userMapper.selectByExample(userExample);
        return users != null ? users.get(0) : null;
    }

    public List<UserTo> getAllUser() {
        List<UserTo> userTos = userMapper.selectAll();
        for (UserTo userTo : userTos) {
            Integer userId = userTo.getUserId();
            //articleMapper
        }
        return userTos;
    }


    public boolean exist(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        long count = userMapper.countByExample(userExample);
        return count >= 1;
    }

    public User getOneByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int updateUser(User user) {
        user.setUserUpdateTime(new Date());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int deleteOne(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    public int save(User user) {
        Date date = new Date();
        user.setUserRegisterTime(date);
        user.setUserUpdateTime(date);
        user.setUserStatus(1);
        return userMapper.insert(user);
    }

    public boolean existEmail(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserEmailEqualTo(email);
        long count = userMapper.countByExample(userExample);
        return count >= 1;
    }

    public User getOneByUserName(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        final List<User> users = userMapper.selectByExample(userExample);
        User user = null;
        if (users != null) {
            user = users.get(0);
            user.setUserPassword("");
        }
        return user;
    }

    /**
     * 根据用户名查找用户avatarUrl,用户名唯一
     *
     * @param userName
     * @return
     */
    public String getUserAvatarUrl(String userName) {
        User user = new User();
        user.setUserAvatarUrl("");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        User ret = userMapper.selectSelectiveWithReturnSelective(user, userExample);
        return ret == null ? null : ret.getUserAvatarUrl();
    }

    public int updateLoginTimeAndIP(Date date, String ip, String userName) {
        User user = new User();
        user.setUserUpdateTime(date);
        user.setUserLastLoginIp(ip);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        return userMapper.updateByExampleSelective(user, userExample);
    }
}
