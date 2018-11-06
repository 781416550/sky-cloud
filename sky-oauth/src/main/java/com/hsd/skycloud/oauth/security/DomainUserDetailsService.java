package com.hsd.skycloud.oauth.security;


import com.hsd.skycloud.api.entity.Role;
import com.hsd.skycloud.oauth.fegin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务
 * 实现 Spring Security的UserDetailsService接口方法，用于身份认证
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;   // 账户数据操作接口

    /**
     * 根据用户名查找账户信息并返回用户信息实体
     * @param username 用户名
     * @return 用于身份认证的 UserDetails 用户信息实体
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.hsd.skycloud.api.entity.User userByUsername = userService.findUserByUsername(username);
        if (userByUsername!=null){
            List<Role> roles = userByUsername.getRoles();
            String[] strings = roles.toArray(new String[roles.size()]);
            return new User(userByUsername.getUsername(),userByUsername.getPassword(), AuthorityUtils.createAuthorityList(strings));
        }else {
            throw  new UsernameNotFoundException("用户["+username+"]不存在");
        }
    }
}
