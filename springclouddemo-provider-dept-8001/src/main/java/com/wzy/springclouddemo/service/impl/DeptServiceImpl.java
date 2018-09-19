package com.wzy.springclouddemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzy.springclouddemo.dao.IDeptDAO;
import com.wzy.springclouddemo.service.IDeptService;
import com.wzy.vo.Dept;

@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private IDeptDAO deptDAO;
	
	@Override
	public Dept get(long id) {
		// TODO Auto-generated method stub
		return this.deptDAO.findById(id);
	}

	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return this.deptDAO.doCreate(dept);
	}

	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return this.deptDAO.findAll();
	}

}
