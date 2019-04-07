package com.multids.example.app.dao;

import java.util.List;

import com.multids.example.app.model.Employee;

public interface EmployeeDao {

	public Employee getEmployeeById(Integer empId);
	public List<Employee> getAllEmployees();
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer empId);
}
