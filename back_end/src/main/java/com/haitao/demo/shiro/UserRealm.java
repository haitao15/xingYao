package com.haitao.demo.shiro;

import com.haitao.demo.pojo.User;
import com.haitao.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权方法");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //实际上应该从数据库中查询用户的权限
        simpleAuthorizationInfo.addStringPermission("user:add");

        //获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        //数据库中查询用户的权限
        //simpleAuthorizationInfo.addStringPermission();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证方法");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //数据库查询当前用户
        User user = userService.getUserByName(token.getUsername());

        if(user == null) {
            return null;//抛出UnknownAccountException异常
        }

        //密码认证，shiro操作,加密
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
