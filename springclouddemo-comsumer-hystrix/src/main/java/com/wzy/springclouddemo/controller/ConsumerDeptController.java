package com.wzy.springclouddemo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wzy.vo.*;



@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://SPRINGCLOUDDEMO-PROVIDER-DEPT/dept/get/";
	public static final String DEPT_LIST_URL = "http://SPRINGCLOUDDEMO-PROVIDER-DEPT/dept/list/";
	public static final String DEPT_ADD_URL = "http://SPRINGCLOUDDEMO-PROVIDER-DEPT/dept/add";
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private HttpHeaders headers;
	
	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Object getDept(@PathVariable long id) {
	
		Dept dept = this.restTemplate.exchange(DEPT_GET_URL + id, HttpMethod.GET,
						new HttpEntity<Object>(this.headers), Dept.class).getBody();
  						//(url, method, requestEntity, responseType)
		return dept;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		List<Dept> allDepts = this.restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
						new HttpEntity<Object>(this.headers), List.class).getBody();
		return allDepts;
	}
	
	
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) {
		Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers), Boolean.class).getBody();
		return flag;
	}
}
