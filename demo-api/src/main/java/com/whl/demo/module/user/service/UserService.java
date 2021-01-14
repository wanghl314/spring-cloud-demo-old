package com.whl.demo.module.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo-user")
public interface UserService {
    @GetMapping("/user/test")
    String test() throws Exception;
}
