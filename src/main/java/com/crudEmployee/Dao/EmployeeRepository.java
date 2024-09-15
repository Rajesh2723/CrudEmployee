package com.crudEmployee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudEmployee.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
