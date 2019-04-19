package com.multids.example.app.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.multids.example.app.dao.ProjectDao;
import com.multids.example.app.documents.Project;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void createNewProject(Project project) {
		mongoTemplate.insert(project,"projectDetails");
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
