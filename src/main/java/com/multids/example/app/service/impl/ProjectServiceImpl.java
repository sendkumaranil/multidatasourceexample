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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProjectByTeamId(String teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project getProjectByDateRange(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProject(String projectId) {
		// TODO Auto-generated method stub

	}

}
