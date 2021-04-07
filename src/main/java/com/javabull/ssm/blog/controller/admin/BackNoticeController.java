package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Notice;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin/notice")
@Controller
public class BackNoticeController {

    @Autowired
    private INoticeService noticeService;

    public Msg check(Notice notice) {
        if (notice.getNoticeContent().length() >= 10000) {
            Msg msg = new Msg();
            msg.setMsg("公告超过最大长度,请修改!");
            msg.setCode(200);
            return msg;
        }
        boolean flag = noticeService.exist(notice.getNoticeTitle());
        if (flag) {
            Msg msg = new Msg();
            msg.setMsg("公告名已存在,请修改!");
            msg.setCode(200);
            return msg;
        }
        return Msg.success();
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<Notice> notices = noticeService.getAll();
        map.put("notices", notices);
        return "Admin/Notice/index";
    }

    @RequestMapping(value = "/edit/{noticeId}", method = RequestMethod.GET)
    public String editPage(@PathVariable("noticeId") Integer noticeId, Map<String, Object> map) {
        Notice notice = noticeService.get(noticeId);
        map.put("notice", notice);
        return "Admin/Notice/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(Notice notice, String copyNoticeTitle) {
        if (copyNoticeTitle!=null&&!copyNoticeTitle.equals(notice.getNoticeTitle())){
            Msg msg = check(notice);
            if (msg.getCode() != 100) {
                return msg;
            }
        }
        try {
            noticeService.updateNotice(notice);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertPage() {
        return "admin/Notice/insert";
    }

    @ResponseBody
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public Msg insertSubmit(Notice notice) {
        Msg msg = check(notice);
        if (msg.getCode() != 100) {
            return msg;
        }
        noticeService.insert(notice);
        return Msg.success();
    }

    @RequestMapping(value = "/delete/{noticeId}", method = RequestMethod.GET)
    public String delete(@PathVariable("noticeId") Integer noticeId) {
        noticeService.delete(noticeId);
        return "redirect:/admin/notice";
    }
}
