package com.whl.demo.module.token.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.whl.demo.module.token.service.TokenService;

@DubboService
public class TokenServiceImpl implements TokenService {
    @Autowired
    private Environment environment;

    @Override
    public String test() throws Exception {
        String tokenName = this.environment.getProperty("dubbo.token.name");
        String token = RpcContext.getContext().getAttachment(tokenName);

        if (StringUtils.isBlank(token)) {
            return "TokenServiceImpl [" + tokenName + " not found]";
        }
        return "TokenServiceImpl";
    }

}
