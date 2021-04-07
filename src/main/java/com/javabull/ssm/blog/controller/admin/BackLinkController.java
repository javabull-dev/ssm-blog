package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Link;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin/link")
@Controller
public class BackLinkController {

    @Autowired
    private ILinkService linkService;

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<Link> all = linkService.getAll();
        map.put("links", all);
        return "Admin/Link/index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertPage() {
        return "admin/Link/insert";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(Link link) {
        linkService.saveOne(link);
        return "redirect:/admin/link/index";
    }

    @ResponseBody
    @RequestMapping(value = "/checkLinkTitle", method = RequestMethod.POST)
    public Msg checkLinkTitle(String title) {
        boolean flag = linkService.existTitle(title);
        if (flag) {
            return Msg.fail("链接名已存在!");
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{linkId}", method = RequestMethod.POST)
    public Msg delete(@PathVariable("linkId") Integer linkId) {
        linkService.delete(linkId);
        return Msg.success();
    }

    @RequestMapping(value = "/edit/{linkId}", method = RequestMethod.GET)
    public String editPage(@PathVariable("linkId") Integer linkId, Map<String, Object> map) {
        Link link = linkService.getOne(linkId);
        map.put("link", link);
        return "Admin/Link/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(Link link, String copyLinkTitle) {
        if (copyLinkTitle != null && !copyLinkTitle.equals(link.getLinkTitle())) {
            boolean b = linkService.existTitle(link.getLinkTitle());
            if (b) {
                return Msg.fail("链接名已存在,请修改!");
            }
        }
        linkService.updateOne(link);
        return Msg.success();
    }
}
