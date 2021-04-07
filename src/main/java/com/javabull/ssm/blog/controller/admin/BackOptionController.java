package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.Options;
import com.javabull.ssm.blog.service.IOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping(value = "/admin/options")
@Controller
public class BackOptionController {

    @Autowired
    private IOptionsService optionsService;

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        Options options = optionsService.getOption();
        map.put("options", options);
        return "Admin/Options/index";
    }

    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editSubmit(Options options) {
        optionsService.update(options);
        return "Admin/Options/index";
    }
}
