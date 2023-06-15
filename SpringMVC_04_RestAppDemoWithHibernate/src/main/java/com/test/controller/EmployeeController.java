package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Employee;
import com.test.service.EmployeeService;
import com.test.util.HibernateUtil;

@RestController
@RequestMapping(value = "/employee") // URL : https://localhost:8080/employee/getEmployee?id=099?name="darshit"
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/getEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee empl1 = new Employee(001, "Darshit", "Patel", 25, 5000d);
		Employee empl2 = new Employee(002, "Ravi", "Patil", 22, 4500d);
		Employee empl3 = new Employee(003, "Amit", "Bhatt", 27, 6000.50);
		employees.add(empl1);
		employees.add(empl2);
		employees.add(empl3);
		return employees;
	}

	@GetMapping(value = "/getEmployee/{darshit}/{param2}")
	public Employee getEmployeeById(@PathVariable("darshit") String id, @PathVariable("param2") String name) {
		System.out.println("==========>>>>>id from getEmployeeById" + id);
		Employee employee = new Employee();
		// employee.setId(id);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	}

	@GetMapping(value = "/getEmployeeRP")
	public Employee getEmployeeByIdpp(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam("name") String name) {
		System.out.println("========>>>>> id from getEmployeeByUsing RequestParam " + id);
		System.out.println("========>>>>> Name from getEmployeeByUsing RequestParam " + name);
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	}

	@PutMapping(value = "/createEmployee", produces = {"application/JSON", "application/XML"})
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
}