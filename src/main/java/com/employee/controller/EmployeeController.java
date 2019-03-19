package com.employee.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/" })
public class EmployeeController {

	private List<Employee> employees = createList();

	@GetMapping(produces = "application/json")
	public List<Employee> displayEmployees() {
		return employees;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setEmpId("1");

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setEmpId("2");
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

}