package com.crudEmployee.dao;

import java.util.List;

import com.crudEmployee.Models.Employee;

public interface EmployeeDao {
	
	List<Employee>findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
