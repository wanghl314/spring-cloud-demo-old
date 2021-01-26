package com.whl.demo.module.compound.service.fallback;

import org.springframework.stereotype.Component;

import com.whl.demo.module.compound.service.CompoundService;

@Component
public class CompoundServiceFallback implements CompoundService {

    @Override
    public String test() throws Exception {
        return "CompoundServiceFallback test";
    }

    @Override
    public String testFallback() throws Exception {
        return "CompoundServiceFallback testFallback";
    }

    @Override
    public String logTest() throws Exception {
        return "CompoundServiceFallback logTest";
    }

    @Override
    public String userTest() throws Exception {
        return "CompoundServiceFallback userTest";
    }

    @Override
    public String tokenTest() throws Exception {
        return "CompoundServiceFallback tokenTest";
    }

}
