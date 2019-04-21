package com.multids.example.app.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
		
		return mongoTemplate.findById(projectId, Project.class, "projectDetails");
	}

	@Override
	public Project getProjectByTeamId(String teamId) {
		return mongoTemplate.findOne(Query.query(Criteria.where("team.teamId").is(teamId)), Project.class,"projectDetails");
	}

	@Override
	public List<Project> getProjectByDateRange(Date startDate, Date endDate) {
		Query query=new Query();
		query.addCriteria(Criteria.where("startDate").lt(endDate).gt(startDate));
		return mongoTemplate.find(query, Project.class, "projectDetails");
	}

	@Override
	public List<Project> getProjects() {
		List<Project> projects=mongoTemplate.findAll(Project.class, "projectDetails");;
		return projects;
	}

	@Override
	public void updateProject(Project project) {
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(project.getProjectId()));
		Update update=new Update();
		update.set("team", project.getTeam());
		mongoTemplate.updateFirst(query, update, "projectDetails");
	}

	@Override
	public void deleteProject(String projectId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("_id").is(projectId));
		mongoTemplate.remove(query, Project.class, "projectDetails");
	}
}
