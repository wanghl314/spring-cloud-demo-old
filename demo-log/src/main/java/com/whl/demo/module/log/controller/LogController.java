package com.whl.demo.module.log.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.log.service.LogService;
import com.whl.demo.module.log.vo.PostVo;

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

    @GetMapping("/testFallback")
    public String testFallback() {
        int i = 1 / 0;
        return "LogController: testFallback";
    }

    @PostMapping("/testpost")
    public String testPost(@RequestBody PostVo post) throws Exception {
        return "LogController: " + this.logService.testPost(post);
    }

}
