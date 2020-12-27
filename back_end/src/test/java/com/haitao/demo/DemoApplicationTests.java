package com.haitao.demo;

import com.haitao.demo.dao.RoleMapper;
import com.haitao.demo.dao.UserMapper;
import com.haitao.demo.dao.UserRoleMapper;
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


    @Test
    void contextLoads() {
    }

    @Test
    void testGetUserById() {
        System.out.println(userMapper.getUserById(2));
    }

    @Test
    void testGetUserByName() {
        System.out.println(userMapper.getUserByName("haitao"));
        System.out.println(userMapper.getUserByName("ha1itao"));
    }


    @Test
    void testGetRoleById() {
        System.out.println(roleMapper.getRoleById(1));
    }

    @Test
    void testGetRoleIdByUserId() {
        System.out.println(userRoleMapper.getRoleIdByUserId(1));
        System.out.println(userRoleMapper.getRoleIdByUserId(2));
    }
}
