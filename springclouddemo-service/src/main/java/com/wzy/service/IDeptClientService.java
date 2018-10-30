package com.wzy.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzy.commons.config.FeignClientConfig;
import com.wzy.vo.Dept;



@FeignClient(value="SPRINGCLOUDDEMO-PROVIDER-DEPT",configuration=FeignClientConfig.class, fallbackFactory = com.wzy.service.fallback.IDeptClientServiceFallbackFactory.class) //value后接Provider的application name一致
public interface IDeptClientService {
	@RequestMapping(method=RequestMethod.GET,value="/dept/get/{id}")
	public Dept get(@PathVariable("id") long id) ;
	
	@RequestMapping(method=RequestMethod.GET,value="/dept/list")
	public List<Dept> list() ;
	
	@RequestMapping(method=RequestMethod.POST,value="/dept/add")
	public boolean add(Dept dept) ;
}
