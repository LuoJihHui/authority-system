package com.ljh.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * center模块：负载eureka服务注册发现;Zuul网关路由、限流
 *
 * @author luojiahui
 * @date 20200615 10:20:25
 */
@SpringBootApplication
@EnableEurekaServer
@EnableZuulProxy
@EnableFeignClients
@ComponentScan("com.ljh.*")
public class CenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }

}
