package com.hsd.skycloud.oauth.fegin;

import com.hsd.skycloud.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Exrickx
 */
@FeignClient(name = "base-server")
public interface UserService {
    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    @GetMapping("/user/getUserByUsername")
    User findUserByUsername(String username);

}
