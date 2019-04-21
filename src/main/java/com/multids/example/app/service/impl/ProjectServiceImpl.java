package com.multids.example.app.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multids.example.app.dao.ProjectDao;
import com.multids.example.app.documents.Project;
import com.multids.example.app.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void createNewProject(Project project) {
		projectDao.createNewProject(project);
	}

	@Override
	public Project getProjectById(String projectId) {
		return projectDao.getProjectById(projectId);
	}

	@Override
	public Project getProjectByTeamId(String teamId) {
		return projectDao.getProjectByTeamId(teamId);
	}

	@Override
	public List<Project> getProjectByDateRange(Date startDate, Date endDate) {
		return projectDao.getProjectByDateRange(startDate, endDate);
	}

	@Override
	public List<Project> getProjects() {
		return projectDao.getProjects();
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);
	}

	@Override
	public void deleteProject(String projectId) {
		projectDao.deleteProject(projectId);
	}

}
