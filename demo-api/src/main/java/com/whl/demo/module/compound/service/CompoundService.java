package com.whl.demo.module.compound.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-compound")
public interface CompoundService {
    @GetMapping("/compound/test")
    String test() throws Exception;

    @GetMapping("/compound/log/test")
    String logTest() throws Exception;

    @GetMapping("/compound/user/test")
    String userTest() throws Exception;
}
