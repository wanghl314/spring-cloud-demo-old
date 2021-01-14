package com.whl.demo.module.log.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.log.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {
    @DubboReference
    private LogService logService;

    @GetMapping("")
    public String index() {
        return "LogController: index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "LogController: " + this.logService.test();
    }

}
