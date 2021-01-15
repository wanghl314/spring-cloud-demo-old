package com.whl.demo.module.token.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-token")
public interface TokenService {
    @GetMapping("/token/test")
    String test() throws Exception;
}
