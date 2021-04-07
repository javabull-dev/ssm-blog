package com.javabull.ssm.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTo implements Serializable {
    private Integer userId;

    private String userName;

    private String userAvatarUrl;

    private String userIntroduction;

    private Date userRegisterTime;

    private Date userUpdateTime;

    private Date userLastLoginTime;

    private Integer userStatus;

    private String userNickName;

    private String userLastLoginIp;

    private Integer articleCount;

    private String userEmail;
}
