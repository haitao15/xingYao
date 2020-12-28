package com.haitao.demo.service;

import com.haitao.demo.pojo.User;

public interface UserService {

    User getUserById(Integer id);

    User getUserByName(String name);
}
