package com.crudEmployee.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crudEmployee.Models.Employee;
import com.crudEmployee.dao.EmployeeDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	//define a field for entitymanager
	private EntityManager entityManager;
	
	//setup a contruEntityManagerctor injection
	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		 
		//create a query
		TypedQuery<Employee>theQuery=entityManager.createQuery("from Employee",Employee.class);
		
		//execute the query 
		List<Employee>employees=theQuery.getResultList();
		//return result
		
		return employees;
	}
	
}
