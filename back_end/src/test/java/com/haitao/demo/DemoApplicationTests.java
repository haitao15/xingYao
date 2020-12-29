package com.haitao.demo;

import com.haitao.demo.dao.RoleMapper;
import com.haitao.demo.dao.UserMapper;
import com.haitao.demo.dao.UserRoleMapper;
import com.haitao.demo.pojo.User;
import com.haitao.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
    }

    @Test
    void testGetUserById() {
        System.out.println(userService.getUserById(2));
        System.out.println(userService.getUserByName("haitao"));
    }

    @Test
    void testGetUserByName() {
        System.out.println(userMapper.getUserByName("haitao"));
        System.out.println(userMapper.getUserByName("ha1itao"));
    }


    @Test
    void testGetRoleById() {
        System.out.println(roleMapper.getRoleById(3));
    }

    @Test
    void testGetRoleIdByUserId() {
        System.out.println(userRoleMapper.getRoleIdByUserId(1));
        System.out.println(userRoleMapper.getRoleIdByUserId(2));
    }
}
