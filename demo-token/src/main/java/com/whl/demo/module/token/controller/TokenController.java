package com.whl.demo.module.token.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.token.service.TokenService;

@RestController
@RequestMapping("/token")
public class TokenController {
    @DubboReference
    private TokenService tokenService;

    @GetMapping("")
    public String index() {
        return "TokenController: index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "TokenController: " + this.tokenService.test();
    }

}
