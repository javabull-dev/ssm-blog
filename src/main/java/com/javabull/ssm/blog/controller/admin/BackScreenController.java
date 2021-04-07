package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Screen;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.entity.ScreenParam;
import com.javabull.ssm.blog.service.IScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/admin/screen")
@Controller
public class BackScreenController {

    @Autowired
    private IScreenService screenService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<ScreenParam> screenParams = screenService.getScreensWithArticleId();
        map.put("screenParams", screenParams);
        return "Admin/Screen/index";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(Screen screen) {
        screenService.addOne(screen);
        return "redirect:/admin/screen/index";
    }

    @RequestMapping(value = "/checkScreenTitle", method = RequestMethod.POST)
    public Msg checkScreenTitle(String screenTitle) {
        boolean flag = screenService.existScreenTitle(screenTitle);
        if (flag) {
            return Msg.fail("大幕名存在!");
        }
        return Msg.success().setMsg("大幕名不存在!");
    }


}
