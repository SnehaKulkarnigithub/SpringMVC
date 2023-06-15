package com.test.dao;

import org.springframework.stereotype.Repository;

import com.test.beans.Employee;

@Repository
public interface EmployeeDAO {
	public Boolean validateUser(Employee employee);
	public Employee createEmployee(Employee employee);
	
	
}
