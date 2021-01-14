package com.whl.demo.module.compound.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.user.service.UserService;

@RestController
@RequestMapping("/compound")
public class CompoundController {
    @DubboReference
    private LogService logService;

    @DubboReference
    private UserService userService;

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

}
