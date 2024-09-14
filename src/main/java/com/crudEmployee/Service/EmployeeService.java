package com.crudEmployee.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudEmployee.Models.Employee;


public interface EmployeeService {
		
	List<Employee>findAll();
}
