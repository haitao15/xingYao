package com.haitao.demo.service;

import com.haitao.demo.pojo.User;
import com.haitao.demo.service.model.UserModel;

public interface UserService {

    UserModel getUserById(Integer id);

    UserModel getUserByName(String name);
}
