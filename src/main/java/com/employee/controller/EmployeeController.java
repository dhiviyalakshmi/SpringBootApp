package com.employee.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	

	@PostMapping({"/addemployee"})
	public Employee createEmployee(@RequestBody Employee user){
		employees.add(user);
		return user;
	}
	
	@DeleteMapping({"/deleteemployee/{id}"})
	public Employee deleteEmployee(@PathVariable("id") int id){
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			System.out.println(emp.getEmpId());
			if (emp.getEmpId().equals(String.valueOf(id))) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	
	}
	@PostMapping({"/editemployee/{id}"})
	public @ResponseBody Employee editEmployee(@PathVariable("id") int empid,@RequestBody Employee user){
		for (Employee emp : employees) {
			System.out.println(emp.getEmpId());
			if (emp.getEmpId().equals(String.valueOf(empid))) {
				employees.remove(emp);
				employees.add(user);
				break;
			}
		}
		return user;
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