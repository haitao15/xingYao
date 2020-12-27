package com.haitao.demo.dao;

import com.haitao.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper {

    Role getRoleById(Integer id);
}
