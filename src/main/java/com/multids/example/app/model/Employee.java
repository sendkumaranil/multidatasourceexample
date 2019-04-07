package com.multids.example.app.model;

public class Employee {

	private Integer empId;
	private String empName;
	private String emailid;
	private String mobilenumber;
	
	public Employee() {}
	
	public Employee(Integer empId, String empName, String emailid, String mobilenumber) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
}
