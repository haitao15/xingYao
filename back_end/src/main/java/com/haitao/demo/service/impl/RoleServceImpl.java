package com.haitao.demo.service.impl;

import com.haitao.demo.dao.RoleMapper;
import com.haitao.demo.pojo.Role;
import com.haitao.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role getRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }
}
