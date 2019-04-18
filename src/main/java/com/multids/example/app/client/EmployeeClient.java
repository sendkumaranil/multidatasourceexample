package com.multids.example.app.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.multids.example.app.model.Employee;
import com.multids.example.app.service.EmployeeService;
import com.multids.example.app.utils.Client;

@Client
public class EmployeeClient {

	@Autowired
	EmployeeService employeeService;
	
	public void createEmployee(Employee employee) {
		employeeService.createEmployee(employee);
	}
	
	public void printEmployees(Integer empId) {
		Employee emp=employeeService.getEmployeeById(empId);
		System.out.println("================ [Employee("+empId+") ] =============");
		System.out.println("Employee Id: "+emp.getEmpId());
		System.out.println("Employee Name: "+emp.getEmpName());
		System.out.println("Employee Email: "+emp.getEmailid());
		System.out.println("Employee Contact: "+emp.getMobilenumber());
		System.out.println("=====================================================");
	}
	
	public void printEmployees() {
		List<Employee> emplist=employeeService.getAllEmployees();
		emplist.forEach(emp -> {
			System.out.println("================ [Employee("+emp.getEmpId()+") ] =============");
			System.out.println("Employee Id: "+emp.getEmpId());
			System.out.println("Employee Name: "+emp.getEmpName());
			System.out.println("Employee Email: "+emp.getEmailid());
			System.out.println("Employee Contact: "+emp.getMobilenumber());
			System.out.println("=====================================================");
		});
	}
	
	public void updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
	}
	
	public void deleteEmployee(Integer empId) {
		employeeService.deleteEmployee(empId);
	}
}
