package com.whl.demo.common.dubbo.filter;

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

@Activate(group = CommonConstants.PROVIDER, order = 2)
public class TokenVerifyFilter implements Filter, EnvironmentAware {
    private Environment environment;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String tokenVerifyEnabled = this.environment.getProperty("dubbo.token.verify.global.enabled");

        if ("true".equalsIgnoreCase(tokenVerifyEnabled)) {
            String tokenVerifyBasePackages = this.environment.getProperty("dubbo.token.verify.base-packages");

            if (StringUtils.isNotBlank(tokenVerifyBasePackages)) {
                String[] basePackages = tokenVerifyBasePackages.split(",");
                boolean verify = false;

                if (basePackages.length > 0) {
                    String serviceName = invocation.getServiceName();

                    if (StringUtils.isNotBlank(serviceName)) {
                        for (String basePackage : basePackages) {
                            if (serviceName.startsWith(basePackage)) {
                                verify = true;
                            }
                        }
                    }

                    if (!verify) {
                        String targetServiceUniqueName = invocation.getTargetServiceUniqueName();

                        if (StringUtils.isNotBlank(targetServiceUniqueName)) {
                            String springApplicationName = this.environment.getProperty("spring.application.name");

                            for (String basePackage : basePackages) {
                                if (targetServiceUniqueName.startsWith(basePackage) ||
                                        targetServiceUniqueName.startsWith(springApplicationName + "/" + basePackage)) {
                                    verify = true;
                                }
                            }
                        }
                    }
                }

                if (verify) {
                    String tokenName = this.environment.getProperty("dubbo.token.name");
                    String token = RpcContext.getContext().getAttachment(tokenName);

                    if (StringUtils.isBlank(token)) {
                        throw new RpcException(tokenName + " cannot be blank");
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
