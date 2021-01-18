package com.whl.demo.module.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.whl.demo.module.feign.interceptor.FeignRequestInterceptor;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor defaultFeignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }

}
