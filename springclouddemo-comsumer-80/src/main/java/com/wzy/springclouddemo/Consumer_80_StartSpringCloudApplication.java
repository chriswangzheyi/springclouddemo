package com.wzy.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.wzy.commons.config.MyLoadBalanceConfig;



@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.wzy.service,com.wzy.springclouddemo")
@RibbonClient(name="ribbonClient",configuration=MyLoadBalanceConfig.class)  //采用自定义Ribbon配置需要该注解
public class Consumer_80_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Consumer_80_StartSpringCloudApplication.class,
				args);
	}
}
