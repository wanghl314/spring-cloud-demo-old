package com.whl.demo.common.dubbo.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Activate(group = CommonConstants.CONSUMER, order = 1)
public class TokenTransferFilter implements Filter, EnvironmentAware {
    private Environment environment;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String tokenTransferEnabled = this.environment.getProperty("dubbo.token.transfer.enabled");

        if ("true".equalsIgnoreCase(tokenTransferEnabled)) {
            String tokenTransferBasePackages = this.environment.getProperty("dubbo.token.transfer.base-packages");

            if (StringUtils.isNotBlank(tokenTransferBasePackages)) {
                String[] basePackages = tokenTransferBasePackages.split(",");
                boolean transfer = false;

                if (basePackages.length > 0) {
                    String serviceName = invocation.getServiceName();

                    if (StringUtils.isNotBlank(serviceName)) {
                        for (String basePackage : basePackages) {
                            if (serviceName.startsWith(basePackage)) {
                                transfer = true;
                            }
                        }
                    }
                }

                if (transfer) {
                    RequestAttributes attributes = RequestContextHolder.getRequestAttributes();

                    if (attributes != null) {
                        HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();

                        if (request != null) {
                            String tokenRequestHeaderName = this.environment.getProperty("dubbo.token.transfer.request-header.name");
                            String tokenName = this.environment.getProperty("dubbo.token.name");
                            String token = request.getHeader(tokenRequestHeaderName);
                            RpcContext.getContext().setAttachment(tokenName, token);
                        }
                    }
                }
            }
        }
        return invoker.invoke(invocation);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
