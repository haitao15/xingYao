package com.haitao.demo.controller;

import com.haitao.demo.pojo.User;
import com.haitao.demo.response.Result;
import com.haitao.demo.response.ResultCodeEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user, Model model) {
//        System.out.println(user);
        String username = user.getName();
        String password = user.getPassword();

        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return Result.ok(ResultCodeEnum.SUCCESS_LOGIN);
        } catch (UnknownAccountException e) {
//            model.addAttribute("msg", "用户名错误");
            return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
        } catch (IncorrectCredentialsException e) {
//            model.addAttribute("msg", "密码错误");
            return Result.error(ResultCodeEnum.ERROR_PASSWORD);
        }
    }

    @RequestMapping("/userHome")
    @ResponseBody
    public String userHome() {

        return "userHome";
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public String add() {
        return "add";
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public String update() {
        return "update";
    }


    @RequestMapping("/adminHome")
    @ResponseBody
    public String adminHome() {
        return "adminHome";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String noauth() {
        return "未经授权的页面跳转";
    }
}
