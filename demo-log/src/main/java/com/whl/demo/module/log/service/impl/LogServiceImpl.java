package com.whl.demo.module.log.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.whl.demo.module.log.service.LogService;

@DubboService
public class LogServiceImpl implements LogService {

    @Override
    public String test() throws Exception {
        return "LogServiceImpl";
    }

}
