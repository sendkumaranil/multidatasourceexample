package com.multids.example.app.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multids.example.app.dao.EmployeeDao;
import com.multids.example.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Employee getEmployeeById(Integer empId) {
		String sql="select empid,empname,emailid,mobilenumber from employees where empid=?";
		Employee emp=jdbcTemplate.queryForObject(sql, new Object[] {empId}, new BeanPropertyRowMapper<>(Employee.class));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql="select * from employees";
		List<Employee> employees=new ArrayList<>();
		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
		
		rows.forEach(row -> {
			Employee emp=new Employee();
			emp.setEmpId((Integer)row.get("empid"));
			emp.setEmpName((String)row.get("empname"));
			emp.setEmailid((String)row.get("emailid"));
			emp.setMobilenumber((String)row.get("mobilenumber"));
			employees.add(emp);
		});
		return employees;
	}

	@Override
	public void createEmployee(Employee employee) {
		setupConnection();
		String sql="insert into employees values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {employee.getEmpId(),employee.getEmpName(),employee.getEmailid(),employee.getMobilenumber()});
	}

	@Override
	public void updateEmployee(Employee employee) {

		String sql="update employees set emailid=?,mobilenumber=? where empid=?";
		jdbcTemplate.update(sql, new Object[] {employee.getEmailid(),employee.getMobilenumber(),employee.getEmpId()});
	}

	@Override
	public void deleteEmployee(Integer empId) {
		String sql="delete from employees where empid=?";
		jdbcTemplate.update(sql, new Object[] {empId});
	}

	@PostConstruct
	private void initDb() throws SQLException {
	    
	    setupConnection();
	   jdbcTemplate.execute("create table employees(empid integer not null,empname varchar(50),emailid varchar(50),mobilenumber varchar(25),primary key(empid))");
	}
	
	private void setupConnection() {
		try {
			jdbcTemplate.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
