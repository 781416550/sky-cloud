package com.hsd.skycloud.api.service;


import com.hsd.skycloud.api.entity.User;
import com.hsd.skycloud.common.base.BaseXCloudService;

/**
 * @author Exrickx
 */
public interface UserService extends BaseXCloudService<User,String> {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
