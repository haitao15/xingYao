package com.haitao.demo.controller;

import com.haitao.demo.pojo.User;
import com.haitao.demo.response.Result;
import com.haitao.demo.response.ResultCodeEnum;
import com.haitao.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

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
            Result result = Result.ok(ResultCodeEnum.SUCCESS_LOGIN);
            result.setData(userService.getUserByName(username));
            return result;
        } catch (UnknownAccountException e) {
//            model.addAttribute("msg", "用户名错误");
            return Result.error(ResultCodeEnum.ERROR_NOT_EXISTS_USER);
        } catch (IncorrectCredentialsException e) {
//            model.addAttribute("msg", "密码错误");
            return Result.error(ResultCodeEnum.ERROR_PASSWORD);
        }
    }

    @RequestMapping("/user/home")
    @ResponseBody
    public Result userHome() {
        return Result.ok(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping("/admin/home")
    @ResponseBody
    public String adminHome() {
        return "adminHome";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public Result toLogin() {
        return Result.ok(ResultCodeEnum.No_AUTHENTICATE);
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public Result noauth() {
        return Result.ok(ResultCodeEnum.No_AUTHORICATE);
    }
}
