package com.whl.demo.module.user.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.whl.demo.module.user.service.UserService;

@DubboService
public class UserServiceImpl implements UserService {

    @Override
    public String test() throws Exception {
        return "UserServiceImpl";
    }

}
