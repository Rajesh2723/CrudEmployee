package com.crudEmployee.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudEmployee.Models.Employee;
import com.crudEmployee.Service.EmployeeService;
import com.crudEmployee.dao.EmployeeDao;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	//injecting employeeDao in EmployeeServiceImpl
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
		this.employeeDao=theEmployeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int theId) {
		 
		return employeeDao.findById(theId);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		 
		return employeeDao.save(theEmployee);
	}
	@Transactional
	@Override
	public void deleteById(int theId) {
		 
		employeeDao.deleteById(theId);
	}
	
}
