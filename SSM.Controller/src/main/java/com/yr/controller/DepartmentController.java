package com.yr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yr.entry.Department;
import com.yr.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	/**
	 * 查询所有数据 
	 * @param map
	 * @return
	 */
	@RequestMapping("/dpms")
	public String list(Map<String,Object> map) {
		List<Department> list = departmentService.selectList();
		map.put("department",list);
		return "list";
	}
	
	/**
	 * 用来查询数据做添加
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/dpm",method=RequestMethod.GET)
	public String add(Map<String,Object> map) {
		map.put("department",new Department()); //  这里不给会报错
		return "input";
	}
	/**
	 * 添加一条数据
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/dpm",method = RequestMethod.POST)
	public String save(Department department) {
		String s1 = department.getManager();
		String s2 = department.getName();
		System.out.println(s1+"----"+s2);
		departmentService.insert(department);
		return "redirect:/dpms";
	}
	
	/**
	 * 用来做修改的数据回显，先将数据回显之后再去执行修改  ----- 修改1
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/dpm/{id}",method = RequestMethod.GET)
	public String get(@PathVariable("id")Integer id,Map<String,Object> map) {
		Department department = departmentService.getDepartmentById(id);
		map.put("department",department);
		
		return "input";
	}
	/**
	 * 之后进此处进行判定id是修改还是添加  ----2修改
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getDepartment(@RequestParam(value="id",required = false)Integer id,Map<String,Object> map) {
		if(id != null ) {
			map.put("department",departmentService.getDepartmentById(id));  //  因为界面需要一个id 进行判断是增加还是修改，所以这里使用@ModelAttribute来获取
			// @RequestParam的属性表示这个id不是必须要的
		}
	}
	/**
	 * 之后将修改的数据转换成PUT传过来进行修改并返回值页面  ---- 3修改
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/dpm",method = RequestMethod.PUT)
	public String update(Department department,Map<String,Object> map) {
		departmentService.update(department);
		return "redirect:/dpms";
	}
	
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/dpm/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id) {
		Department department = new Department();
		department.setId(id);
		departmentService.delete(department);
		return "redirect:/dpms";
	}
}