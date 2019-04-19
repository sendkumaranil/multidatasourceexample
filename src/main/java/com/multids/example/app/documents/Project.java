package com.multids.example.app.documents;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {

	private String _id;
	private String projectTitle;
	private Date startDate;
	private Team team;
	private Employee projectManager;
	private String projectDescription;
	
	public Project() {}
	
	public Project(String projectId, String projectTitle, Date startDate, Team team, Employee projectManager,
			String projectDescription) {
		this._id = projectId;
		this.projectTitle = projectTitle;
		this.startDate = startDate;
		this.team = team;
		this.projectManager = projectManager;
		this.projectDescription = projectDescription;
	}

	public String getProjectId() {
		return _id;
	}
	public void setProjectId(String projectId) {
		this._id = projectId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Employee getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(Employee projectManager) {
		this.projectManager = projectManager;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
}
