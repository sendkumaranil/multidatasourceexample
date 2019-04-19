package com.multids.example.app.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

	private String teamId;
	private String teamName;
	private List<Employee> employees;
	
	public Team() {}

	public Team(String teamId, String teamName, List<Employee> employees) {
		
		this.teamId = teamId;
		this.teamName = teamName;
		this.employees = employees;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Integer getTeamSize() {
		return employees.size();
	}
}
