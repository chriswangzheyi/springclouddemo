package com.wzy.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient //服务注册注解
public class Dept_8001_StartSpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(Dept_8001_StartSpringCloudApplication.class, args);
	}
}
