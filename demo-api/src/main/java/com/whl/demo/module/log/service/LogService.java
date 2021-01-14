package com.whl.demo.module.log.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-log")
public interface LogService {
    @GetMapping("/log/test")
    String test() throws Exception;
}
