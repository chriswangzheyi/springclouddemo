package com.wzy.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.wzy.commons.config.MyLoadBalanceConfig;



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.wzy.service"})
public class Hystrix_Consumer_80_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Hystrix_Consumer_80_StartSpringCloudApplication.class,
				args);
	}
}
