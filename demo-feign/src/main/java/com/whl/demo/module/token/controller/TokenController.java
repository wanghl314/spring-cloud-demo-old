package com.whl.demo.module.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.token.service.TokenService;
import com.whl.demo.module.user.service.UserService;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("")
    public String index() {
        return "feign: token: index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "feign: " + this.tokenService.test();
    }

}
