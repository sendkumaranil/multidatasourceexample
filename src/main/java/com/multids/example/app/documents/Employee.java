package com.multids.example.app.documents;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	private String empId;
	private String empName;
	private Date joinDate;
	private String designation;
	private Contacts contacts;
	
	public Employee() {}

	public Employee(String empId, String empName, Date joinDate, Contacts contacts,String designation) {
		
		this.empId = empId;
		this.empName = empName;
		this.joinDate = joinDate;
		this.contacts = contacts;
		this.designation=designation;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
