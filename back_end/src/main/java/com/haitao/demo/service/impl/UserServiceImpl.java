package com.haitao.demo.service.impl;

import com.haitao.demo.dao.RoleMapper;
import com.haitao.demo.dao.UserMapper;
import com.haitao.demo.dao.UserRoleMapper;
import com.haitao.demo.pojo.Role;
import com.haitao.demo.pojo.User;
import com.haitao.demo.service.UserService;
import com.haitao.demo.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserModel getUserById(Integer userId) {
        User user = userMapper.getUserById(userId);
        if(user == null) {
            return null;
        }
        Integer roleId = userRoleMapper.getRoleIdByUserId(userId);
        Role role = roleMapper.getRoleById(roleId);
        return convertUserToUserModel(user, role.getRole());
    }

    @Override
    public UserModel getUserByName(String name) {
        User user = userMapper.getUserByName(name);
        if(user == null) {
            return null;
        }
        Integer roleId = userRoleMapper.getRoleIdByUserId(user.getId());
        Role role = roleMapper.getRoleById(roleId);
        return convertUserToUserModel(user, role.getRole());
    }


    //包含角色信息
    private UserModel convertUserToUserModel(User user, String role) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        userModel.setRole(role);
        return userModel;
    }
}
