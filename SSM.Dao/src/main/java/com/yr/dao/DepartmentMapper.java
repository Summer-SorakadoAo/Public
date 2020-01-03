package com.yr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yr.entry.Department;

@Repository
public class DepartmentMapper {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Department> selectList() { 
		//  bean属性与数据库进行了一一映射
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
		String sql = "select * from Department";
		List<Department> list = jdbcTemplate.query(sql,rowMapper);
		return list;
	}
	
	/**
	 * 根据ID修改姓名
	 * @param Department
	 */
	public void update(Department department) {
		String sql = "update Department set manager = ?  where id = ?";
		jdbcTemplate.update(sql,department.getManager(),department.getId());
	}
	
	/**
	 * 根据ID进行删除
	 * @param id
	 */
	public void delete(Department department) {
		String sql = "delete from Department where id = ?";
		jdbcTemplate.update(sql,department.getId());
	}
	
	/**
	 * 添加一条数据   字段为 name manager
	 * @param Department
	 */
	public void insert(Department department) {
		String sql = "insert into Department(name,manager) values  (?,?)";
		jdbcTemplate.update(sql,department.getName(),department.getManager());
	}
	
	/**
	 * 根据ID查询数据 
	 * @param id
	 * @return
	 */
	public Department getDepartmentById(int id){
		RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
		String sql = "select * from department where id = ?";
		Department department = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
		return department;
	}
}