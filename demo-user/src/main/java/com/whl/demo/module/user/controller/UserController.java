package com.whl.demo.module.user.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @DubboReference
    private UserService userService;

    @GetMapping("")
    public String index() {
        return "UserController: index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "UserController: " + this.userService.test();
    }

}
