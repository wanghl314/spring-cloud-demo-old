package com.whl.demo.module.log.service.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.whl.demo.module.log.service.LogService;

@Component
public class LogServiceFallbackFactory implements FallbackFactory<LogService> {
    private static Logger logger = LoggerFactory.getLogger(LogServiceFallbackFactory.class);

    @Autowired
    private LogServiceFallback logServiceFallback;

    @Override
    public LogService create(Throwable cause) {
        logger.error(cause.getMessage(), cause);
        return this.logServiceFallback;
    }

}
