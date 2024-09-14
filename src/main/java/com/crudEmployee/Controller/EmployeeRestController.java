package com.crudEmployee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudEmployee.Models.Employee;
import com.crudEmployee.Service.EmployeeService;
import com.crudEmployee.dao.EmployeeDao;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
		
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService) {
		this.employeeService=theemployeeService;
	}
	@GetMapping("/employees")
	public List<Employee>getEmployee(){
		
		return employeeService.findAll();
	}
	
}
