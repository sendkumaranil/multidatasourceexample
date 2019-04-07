package com.multids.example.app.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.multids.example.app.dao.EmployeeDao;
import com.multids.example.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub

	}

}
