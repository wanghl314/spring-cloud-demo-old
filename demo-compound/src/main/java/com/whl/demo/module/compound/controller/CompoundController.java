package com.whl.demo.module.compound.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.token.service.TokenService;
import com.whl.demo.module.user.service.UserService;

@RestController
@RequestMapping("/compound")
public class CompoundController {
    @DubboReference
    private LogService logService;

    @DubboReference
    private UserService userService;

    @DubboReference
    private TokenService tokenService;

    @GetMapping("")
    public String index() {
        return "CompoundController: index";
    }

    @GetMapping("/test")
    public String test() {
        return "CompoundController: test";
    }

    @GetMapping("/log/test")
    public String logTest() throws Exception {
        return "CompoundController: " + this.logService.test();
    }

    @GetMapping("/user/test")
    public String userTest() throws Exception {
        return "CompoundController: " + this.userService.test();
    }

    @GetMapping("/token/test")
    public String tokenTest(HttpServletRequest request) throws Exception {
        System.out.println(request.getHeader("Access-Token"));
        return "CompoundController: " + this.tokenService.test();
    }

}
