package com.wzy.springclouddemo.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	public HttpHeaders getHeaders() { // 要进行一个Http头信息配置
		HttpHeaders headers = new HttpHeaders(); // 定义一个HTTP的头信息
		
		String auth = "demo:demo"; // 认证的原始信息   格式：账号：密码
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
		
		
		// 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
		String authHeader = "Basic " + new String(encodedAuth); //Basic 后需要加一个空格
		headers.set("Authorization", authHeader);
		return headers;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
