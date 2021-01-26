package com.whl.demo.module.compound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whl.demo.module.compound.service.CompoundService;
import com.whl.demo.module.log.service.LogService;

@RestController
@RequestMapping("/compound")
public class CompoundController {
    @Autowired
    private CompoundService compoundService;

    @GetMapping("")
    public String index() {
        return "feign: compound index";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "feign: " + this.compoundService.test();
    }

    @GetMapping("/testFallback")
    public String testFallback() throws Exception {
        return "feign: " + this.compoundService.testFallback();
    }

    @GetMapping("/log/test")
    public String logTest() throws Exception {
        return "feign: " + this.compoundService.logTest();
    }

    @GetMapping("/user/test")
    public String userTest() throws Exception {
        return "feign: " + this.compoundService.userTest();
    }

    @GetMapping("/token/test")
    public String tokenTest() throws Exception {
        return "feign: " + this.compoundService.tokenTest();
    }

}
