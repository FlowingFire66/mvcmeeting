package com.example.controller;

import com.example.domain.UserInfo;
import com.example.service.UserInfoService;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * User: FlowingFire
 * Date: 2017/11/13 0013
 * Time: 20:42
 * Description:
 */
@Controller
public class HomeController {
    @Resource
    UserInfoService userInfoService;

    @RequestMapping({"/", "index"})
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        System.out.println("HomeController.login");
        // 登录失败从request中获取shiro处理的异常信息
        // shiroLoginFailure:就是shiro异常类的全类名

        String msg = "";
        UserInfo byUsername = userInfoService.findByUsername(username);
        System.out.println(byUsername.getPhone());

        return "/user/app";
    }

    @RequestMapping(value = "/register")
    public String register(Long username, String password) {
        return "/register";
    }

    @RequestMapping(value = "/doregister",produces= "text/plain;charset=UTF-8")
    public String doregister(UserInfo userInfo, Model model) {
        //System.out.println(byUsername.getPhone());
        // 此方法不处理登录成功,由shiro进行处理.


        try {
            userInfoService.register(userInfo);
        } catch (Exception e) {
            model.addAttribute("msg","用户名重复！");
            System.out.println("用户");
            return "/register";
        }
        model.addAttribute("msg","注册成功！");

        return "/index";
    }
}