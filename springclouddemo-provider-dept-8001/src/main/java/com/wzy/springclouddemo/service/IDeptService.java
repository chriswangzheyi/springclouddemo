package com.wzy.springclouddemo.service;

import java.util.List;

import com.wzy.vo.Dept;

public interface IDeptService {
	public Dept get(long id);
	public boolean add(Dept dept);
	public List<Dept> list();
	
}
