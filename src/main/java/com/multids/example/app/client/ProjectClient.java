package com.multids.example.app.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.multids.example.app.documents.Project;
import com.multids.example.app.service.ProjectService;
import com.multids.example.app.utils.Client;

@Client
public class ProjectClient {

	@Autowired
	ProjectService projectService;
	
	public void createNewProject(Project project) {
		projectService.createNewProject(project);
	}
}
