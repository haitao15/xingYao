package com.haitao.demo.config;

import com.haitao.demo.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        Map<String, String> map = new LinkedHashMap<>();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        map.put("/user/home","authc");
        map.put("/admin/home","authc");
        map.put("/user/home","perms[user]");
        map.put("/admin/home","perms[admin]");
//        map.put("/*", "authc");

        //设置登陆的请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权页面的请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }


    //DefaultWebSecurityManager: 2
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象 1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


}
