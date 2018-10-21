package com.wzy.commons.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;


//自定义Ribbon类，不能放在启动类同一个包下
public class MyLoadBalanceConfig {
	@Bean
	public IRule ribbonRule() { // 其中IRule就是所有规则的标准
		return new com.netflix.loadbalancer.RandomRule() ; //返回随机可用模式
	}
}
