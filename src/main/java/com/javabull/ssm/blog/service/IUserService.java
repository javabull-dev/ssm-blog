package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.User;
import com.javabull.ssm.blog.entity.UserTo;

import java.util.Date;
import java.util.List;

public interface IUserService {
    User getByAccount(String username);

    List<UserTo> getAllUser();

    boolean exist(String userName);

    User getOneByUserId(Integer userId);

    int updateUser(User user);

    int deleteOne(Integer userId);

    int save(User user);

    boolean existEmail(String email);

    User getOneByUserName(String userName);

    String getUserAvatarUrl(String userName);

    int updateLoginTimeAndIP(Date date, String ip, String userName);
}
