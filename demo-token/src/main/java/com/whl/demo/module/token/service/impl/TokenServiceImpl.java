package com.whl.demo.module.token.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.whl.demo.module.token.service.TokenService;

@DubboService
public class TokenServiceImpl implements TokenService {

    @Override
    public String test() throws Exception {
        return "TokenServiceImpl";
    }

}
