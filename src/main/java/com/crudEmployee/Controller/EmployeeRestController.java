package com.crudEmployee.Controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
	Employee theEmployee=employeeService.findById(employeeId);
	
	if(theEmployee==null) {
		throw new RuntimeException("Employee Id not found:--" +employeeId);
	}
		
		return theEmployee;
		
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		Employee adbEmployee=employeeService.save(theEmployee); 
		return adbEmployee;
		
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee=employeeService.save(theEmployee);
		return theEmployee;
	}
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
//		System.out.println("Data deleted !!");
//		employeeService.deleteById(employeeId);
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("Employee Id not found--" +employeeId);
		}
		employeeService.deleteById(employeeId);
		
		return "Deleted Employee Id:" +employeeId;
		
	}
	
 
	
}
