# spring-cloud-demo

spring-cloud-2020.0.0+spring-cloud-alibaba-2.2.3.RELEASE

eureka+feign+dubbo

要求开发环境已配置好Java和Maven环境变量

### 1. 一键编译并启动所有微服务（服务之前通过dubbo远程调用）  

Windows：/start_all_micro_services.bat  

Linux：/start_all_micro_services.sh

### 2. 一键编译并将所有模块打包为一个服务启动（模块之间通过dubbo injvm方式调用）  

Windows：/demo-boot/start_all_in_one.bat  

Linux：/demo-boot/start_all_in_one.sh
