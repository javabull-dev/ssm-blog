package com.javabull.ssm.blog.service;

import com.javabull.ssm.blog.bean.Notice;

import java.util.List;

public interface INoticeService {
    List<Notice> getAll();

    int delete(Integer noticeId);

    Notice get(Integer noticeId);

    int updateNotice(Notice notice);

    boolean exist(String noticeTitle);

    int insert(Notice notice);
}
