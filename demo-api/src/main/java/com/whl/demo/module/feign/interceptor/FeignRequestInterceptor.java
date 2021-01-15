package com.whl.demo.module.feign.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();

        if (attributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();

            if (request != null) {
                Enumeration<String> headerNames = request.getHeaderNames();

                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String headerName = headerNames.nextElement();
                        Enumeration<String> headerValues = request.getHeaders(headerName);

                        if (headerValues != null) {
                            List<String> headerValueList = new ArrayList<String>();

                            while (headerValues.hasMoreElements()) {
                                headerValueList.add(headerValues.nextElement());
                            }
                            requestTemplate.header(headerName, headerValueList.toArray(new String[headerValueList.size()]));
                        }
                    }
                }
            }
        }
    }

}
