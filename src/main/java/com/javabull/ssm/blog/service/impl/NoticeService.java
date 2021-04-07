package com.javabull.ssm.blog.service.impl;

import com.javabull.ssm.blog.bean.Notice;
import com.javabull.ssm.blog.bean.NoticeExample;
import com.javabull.ssm.blog.dao.NoticeMapper;
import com.javabull.ssm.blog.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeService implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<Notice> getAll() {
        NoticeExample noticeExample = new NoticeExample();
        //升序排列
        noticeExample.setOrderByClause("`tb_notice`.notice_order asc");
        List<Notice> notices = noticeMapper.selectByExample(noticeExample);
        return notices;
    }

    public int delete(Integer noticeId) {
        return noticeMapper.deleteByPrimaryKey(noticeId);
    }

    public Notice get(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    public int updateNotice(Notice notice) {
        notice.setNoticeUpdateTime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    public boolean exist(String noticeTitle) {
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        criteria.andNoticeTitleEqualTo(noticeTitle);
        long count = noticeMapper.countByExample(noticeExample);
        return count >= 1;
    }

    public int insert(Notice notice) {
        Date date = new Date();
        notice.setNoticeUpdateTime(date);
        notice.setNoticeCreateTime(date);
        return noticeMapper.insert(notice);
    }
}
