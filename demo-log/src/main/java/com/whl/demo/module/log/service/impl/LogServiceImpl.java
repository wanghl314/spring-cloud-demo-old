package com.whl.demo.module.log.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.log.vo.PostVo;

@DubboService
public class LogServiceImpl implements LogService {

    @Override
    public String test() throws Exception {
        return "LogServiceImpl";
    }

    @Override
    public String testPost(PostVo post) throws Exception {
        return "LogServiceImpl [content=" + post.getContent() + ", datetime=" + post.getDatetime() + "]";
    }

}
