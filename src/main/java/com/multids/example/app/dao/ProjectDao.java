package com.multids.example.app.dao;

import java.util.Date;
import java.util.List;

import com.multids.example.app.documents.Project;

public interface ProjectDao {

	public void createNewProject(Project project);
	public Project getProjectById(String projectId);
	public Project getProjectByTeamId(String teamId);
	public Project getProjectByDateRange(Date startDate,Date endDate);
	public List<Project> getProjects();
	public void updateProject(Project project);
	public void deleteProject(String projectId);
}
