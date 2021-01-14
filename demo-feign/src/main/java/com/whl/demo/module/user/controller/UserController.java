package com.whl.demo.module.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String index() {
        return "feign: user: index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "feign: " + this.userService.test();
    }

}
