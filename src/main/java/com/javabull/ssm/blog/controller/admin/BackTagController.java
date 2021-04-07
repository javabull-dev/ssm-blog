package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Tag;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.entity.TagWarp;
import com.javabull.ssm.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin/tag")
@Controller
public class BackTagController {

    @Autowired
    private ITagService tagService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<TagWarp> tagWarps = tagService.getAllTagWarp();
        map.put("tagWarps", tagWarps);
        return "Admin/Tag/index";
    }

    @ResponseBody
    @RequestMapping(value = "insertSubmit", method = RequestMethod.POST)
    public Msg insertSubmit(Tag tag) {
        boolean flag = tagService.exist(tag.getTagContent());
        if (flag) {
            Msg msg = new Msg();
            msg.setMsg("标签名已存在,请重新编辑!");
            msg.setCode(200);
            return msg;
        }
        try {
            tagService.saveTag(tag);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/edit/{tagId}", method = RequestMethod.GET)
    public String editPage(@PathVariable("tagId") Integer tagId, Map<String, Object> map) {
        List<TagWarp> tagWarps = tagService.getAllTagWarp();
        map.put("tagWarps", tagWarps);
        Tag tag = tagService.get(tagId);
        map.put("tag", tag);
        return "Admin/Tag/edit";
    }

    @ResponseBody
    @RequestMapping(value = "editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(Tag tag, String copyTagContent, Map<String, Object> map) {
        if (!copyTagContent.equals(tag.getTagContent())){
            boolean flag = tagService.exist(tag.getTagContent());
            if (flag) {
                Msg msg = new Msg();
                msg.setMsg("标签名已存在,请重新编辑!");
                msg.setCode(200);
                return msg;
            }
        }
        try {
            tagService.updateTag(tag);
        }catch (Exception e){
            return Msg.fail();
        }
        return Msg.success();
    }
}
