package com.hsd.skycloud.base.dao;


import com.hsd.skycloud.api.entity.User;
import com.hsd.skycloud.common.base.BaseXCloudDao;

import java.util.List;

/**
 * @author Exrickx
 */
public interface UserDao extends BaseXCloudDao<User,String> {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    List<User> findUserByUsername(String username);
}
