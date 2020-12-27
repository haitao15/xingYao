package com.haitao.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper {

    Integer getRoleIdByUserId(Integer userId);

//    List<Integer> getUserIdByRoleId(Integer roleId);
}
