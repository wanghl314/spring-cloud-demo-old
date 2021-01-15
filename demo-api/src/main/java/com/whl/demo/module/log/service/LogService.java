package com.whl.demo.module.log.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.whl.demo.module.log.vo.PostVo;

@FeignClient("demo-log")
public interface LogService {
    @GetMapping("/log/test")
    String test() throws Exception;

    @PostMapping("/log/testpost")
    String testPost(@RequestBody PostVo post) throws Exception;
}
