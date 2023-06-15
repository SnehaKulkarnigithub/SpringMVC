package com.test.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.test.beans.Employee;
import com.test.dao.EmployeeDAO;
import com.test.util.HibernateUtil;

@Service
public class EmployeeService implements EmployeeDAO {

	@Override
	public Boolean validateUser(Employee employee) {
		if (employee.getFirstName().equals("Darshit")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Employee createEmployee(Employee employee) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

}
