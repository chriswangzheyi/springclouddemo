package com.wzy.test;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wzy.springclouddemo.Dept_8001_StartSpringCloudApplication;
import com.wzy.springclouddemo.service.IDeptService;
import com.wzy.vo.Dept;






@SpringBootTest(classes = Dept_8001_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest {
	@Resource
	private IDeptService deptService ;
	
	
	@Test
	public void testGet() {
		System.out.println(this.deptService.get(1));
	}

	@Test
	public void testAdd() {
		Dept dept = new Dept() ;
		dept.setDname("测试部-" + System.currentTimeMillis());
		System.out.println(this.deptService.add(dept)); 
	}

	@Test
	public void testList() {
		System.out.println(this.deptService.list());
	}

}
