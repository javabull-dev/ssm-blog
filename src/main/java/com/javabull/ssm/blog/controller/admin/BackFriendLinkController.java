package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.FriendLink;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.service.IFriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin/friendlink")
@Controller
public class BackFriendLinkController {

    @Autowired
    private IFriendLinkService friendLinkService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<FriendLink> friendLinks = friendLinkService.getAll();
        map.put("friendLinks", friendLinks);
        return "Admin/FriendLink/index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertPage(Map<String, Object> map) {
        List<FriendLink> friendLinks = friendLinkService.getAll();
        map.put("friendLinks", friendLinks);
        return "Admin/FriendLink/insert";
    }

    @ResponseBody
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public Msg insertSubmit(FriendLink friendLink) {
        //是否已存在
        boolean flag = friendLinkService.exist(friendLink.getLinkName());
        if (flag) {
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("友链名已存在!");
            return msg;
        }
        try {
            friendLinkService.saveFriendLink(friendLink);
        }catch (Exception e){
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/edit/{linkId}", method = RequestMethod.GET)
    public String editPage(@PathVariable("linkId") Integer linkId, Map<String, Object> map) {
        List<FriendLink> friendLinks = friendLinkService.getAll();
        map.put("friendLinks", friendLinks);
        FriendLink friendLink = friendLinkService.getOne(linkId);
        map.put("friendLink", friendLink);
        return "Admin/FriendLink/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(FriendLink friendLink, String copyLinkName) {
        if (copyLinkName != null && !copyLinkName.equals(friendLink.getLinkName())) {
            boolean exist = friendLinkService.exist(friendLink.getLinkName());
            if (exist) {
                Msg msg = new Msg();
                msg.setCode(200);
                msg.setMsg("友链名已存在!");
                return msg;
            }
        }
        friendLinkService.updateFriendLink(friendLink);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{linkId}", method = RequestMethod.POST)
    public Msg delete(@PathVariable("linkId") Integer linkId) {
        try {
            friendLinkService.deleteOne(linkId);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }
}
