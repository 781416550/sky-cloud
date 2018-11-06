package com.hsd.skycloud.base.impl;

import com.hsd.skycloud.api.entity.User;
import com.hsd.skycloud.api.service.UserService;
import com.hsd.skycloud.base.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Exrickx
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "user-service")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDao getRepository() {
        return userDao;
    }

    @Override
    @Cacheable(key = "'user:' + #username")
    public User findUserByUsername(String username) {
        
        List<User> list=userDao.findUserByUsername(username);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
