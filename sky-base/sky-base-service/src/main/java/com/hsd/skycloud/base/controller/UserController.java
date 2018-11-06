package com.hsd.skycloud.base.controller;

import com.hsd.skycloud.api.entity.User;
import com.hsd.skycloud.api.service.UserService;
import com.hsd.skycloud.common.base.BaseXCloudController;
import com.hsd.skycloud.common.utils.ResultUtil;
import com.hsd.skycloud.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Exrickx
 */
@Slf4j
@RestController
@Api(description = "管理员接口")
@RequestMapping("/user")
public class UserController extends BaseXCloudController<User, String> {

    @Autowired
    private UserService userService;

    @Override
    public UserService getService() {
        return userService;
    }

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
    @ApiOperation("通过用户名获取用户")
    public Result<Object> getUserByUsername(@RequestParam String username){
        log.info("Base-Service-----------------------------------");
        User u = userService.findUserByUsername(username);
        return new ResultUtil().setData(u);
    }
}
