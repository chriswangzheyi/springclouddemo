package com.wzy.springclouddemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wzy.vo.Company;


@RestController
public class CompanyController {
	@RequestMapping(value = "/company/get/{title}", method = RequestMethod.GET)
	@HystrixCommand	// 如果需要进行性能监控，那么必须要有此注解
	public Object get(@PathVariable("title") String title) {
		Company vo = new Company() ;
		vo.setTitle(title);
		vo.setNote("www.wzy.com");
		return vo ;
	}
}
