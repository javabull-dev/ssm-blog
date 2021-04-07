package com.javabull.ssm.blog.controller.admin;

import com.javabull.ssm.blog.bean.User;
import com.javabull.ssm.blog.entity.Msg;
import com.javabull.ssm.blog.entity.UserTo;
import com.javabull.ssm.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin/user")
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        List<UserTo> users = userService.getAllUser();
        map.put("users", users);
        return "Admin/User/index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertPage() {
        return "admin/User/insert";
    }

    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertSubmit(User user) {
        boolean flag = userService.exist(user.getUserName());
        if (!flag) {
            userService.save(user);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editPage(@PathVariable("userId") Integer userId, Map<String, Object> map) {
        User user = userService.getOneByUserId(userId);
        map.put("user", user);
        return "Admin/User/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public Msg editSubmit(User user, String copyUserName) {
        if (copyUserName != null && !copyUserName.equals(user.getUserName())) {
            boolean flag = userService.exist(user.getUserName());
            if (flag) {
                Msg msg = new Msg();
                msg.setCode(200);
                msg.setMsg("用户名已存在,请修改!");
                return msg;
            }
        }
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable("userId") Integer userId) {
        userService.deleteOne(userId);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/checkUserEmail", method = RequestMethod.POST)
    @ResponseBody
    public Msg checkUserEmail(String email) {
        boolean flag = userService.existEmail(email);
        if (flag) {
            return Msg.fail("邮箱已存在").setCode(1);
        }
        return Msg.success("").setCode(0);
    }

    @ResponseBody
    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    public Msg checkUserName(String username) {
        boolean flag = userService.exist(username);
        if (flag) {
            return Msg.fail("用户名已存在").setCode(1);
        }
        return Msg.fail("").setCode(0);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(HttpServletRequest httpServletRequest, Map<String, Object> map) {
        final HttpSession session = httpServletRequest.getSession();
        String userName = (String) session.getAttribute("userName");
        User user = userService.getOneByUserName(userName);
        map.put("user", user);
        return "Admin/User/profile";
    }
}
