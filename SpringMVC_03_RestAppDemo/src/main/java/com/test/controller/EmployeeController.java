package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Employee;
 
 @RestController
@Controller
@RequestMapping(value = "/employee") // URL : https://localhost:8080/employee/getEmployee?id=099?name="darshit"
public class EmployeeController {
 
	@ResponseBody
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = "application/json")
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
	
	@ResponseBody
	@GetMapping(value = "/getEmployee/{id}/{name}", produces = "application/json")
	public Employee getEmployeeById(
			@PathVariable("id") Integer id,
			@PathVariable("name") String employeeName) {
		System.out.println("==========>>>>>id from getEmployeeById ::"+id);
		System.out.println("==========>>>>>Employee name from URL ::"+employeeName);
		Employee employee = new Employee();
		employee.setAge(111);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	} 
	//localhost:8080/employee/getemployee/800
	
	@ResponseBody
	@GetMapping(value = "/getEmployeeRP", produces = "application/json")
	public Employee getEmployeeByIdpp(@RequestParam(value = "id", required = false) Integer id) {
		System.out.println("========>>>>> id from getEmployeeByUsing RequestParam "+id);
		Employee employee = new Employee();
		//employee.setAge(id);
		employee.setFirstName("Darshit");
		employee.setLastName("rabadiya");
		employee.setAge(28);
		employee.setSalary(1500000.00);
		return employee;
	} 
	
	@PostMapping("/createEmployee")
	public void createEmployee(@RequestBody Employee employee) {
		System.out.println("====>>> Create emlployee api/url call");
		System.out.println(employee.getId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getAge());
		System.out.println(employee.getSalary());
	}
}