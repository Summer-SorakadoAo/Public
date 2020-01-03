package com.yr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.DepartmentMapper;
import com.yr.entry.Department;
import com.yr.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> selectList() {
		List<Department> list = departmentMapper.selectList();
		return list;
	}

	public void update(Department department) {
		departmentMapper.update(department);
	}

	public void delete(Department department) {
		departmentMapper.delete(department);
	}

	public void insert(Department department) {
		departmentMapper.insert(department);
	}
	
	public Department getDepartmentById(int id) {
		return departmentMapper.getDepartmentById(id);
	}
}
