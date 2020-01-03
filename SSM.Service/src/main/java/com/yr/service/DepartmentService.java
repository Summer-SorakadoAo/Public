package com.yr.service;

import java.util.List;

import com.yr.entry.Department;

public interface DepartmentService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<Department> selectList();
	
	/**
	 * 根据ID修改姓名
	 * @param Department
	 */
	public void update(Department department);
	
	/**
	 * 根据ID进行删除
	 * @param id
	 */
	public void delete(Department department);
	
	/**
	 * 添加一条数据   字段为 name manager
	 * @param Department
	 */
	public void insert(Department department);
	
	/**
	 * 根据ID查询数据 
	 * @param id
	 * @return
	 */
	public Department getDepartmentById(int id);
}
