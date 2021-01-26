package com.whl.demo.module.log.service.fallback;

import org.springframework.stereotype.Component;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.log.vo.PostVo;

@Component
public class LogServiceFallback implements LogService {

    @Override
    public String test() throws Exception {
        return "LogServiceFallback test";
    }

    @Override
    public String testFallback() throws Exception {
        return "LogServiceFallback testFallback";
    }

    @Override
    public String testPost(PostVo post) throws Exception {
        return "LogServiceFallback testPost";
    }

}
