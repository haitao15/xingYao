package com.haitao.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.haitao.demo.pojo.User;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User jsonString) {
//        User user = JSONObject.parseObject(jsonString, User.class);
        System.out.println(jsonString);
        return "index";
    }
}
