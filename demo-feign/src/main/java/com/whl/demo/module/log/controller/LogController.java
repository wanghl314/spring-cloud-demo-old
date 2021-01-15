package com.whl.demo.module.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private LogService logService;

    @GetMapping("")
    public String index() {
        return "feign: log index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "feign: " + this.logService.test();
    }

    @PostMapping("/testpost")
    public String testPost(@RequestBody PostVo post) throws Exception {
        return "feign: " + this.logService.testPost(post);
    }

}
