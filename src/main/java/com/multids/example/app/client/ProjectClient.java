package com.multids.example.app.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	public void printProject(String projectId) {
		Project project=projectService.getProjectById(projectId);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ [ Project(#"+projectId+") ] @@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Project Id:"+project.getProjectId());
		System.out.println("Title:"+project.getProjectTitle());
		System.out.println("Description:"+project.getProjectDescription());
		System.out.println("Start Date:"+project.getStartDate());
		System.out.println("Manager:"+project.getProjectManager().getEmpName());
		System.out.println("Team Details:");
		System.out.println("Team Name:"+project.getTeam().getTeamName());
		System.out.println("Size:"+project.getTeam().getTeamSize());
		System.out.println("Members:");
		project.getTeam().getEmployees().forEach(emp -> {
			System.out.println("Name:"+emp.getEmpName());
			System.out.println("Designation:"+emp.getDesignation());
			System.out.println("Email:"+emp.getContacts().getWorkEmailId());
			System.out.println("Address:"+emp.getContacts().getCurrentAddress().getAddress()+" City:"+emp.getContacts().getCurrentAddress().getCity());
		});
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	public void printProjectByTeamId(String teamId) {
		Project project=projectService.getProjectByTeamId(teamId);
		System.out.println("################# [ Project(#"+project.getProjectId()+") ] #################");
		System.out.println("Project Id:"+project.getProjectId());
		System.out.println("Title:"+project.getProjectTitle());
		System.out.println("Description:"+project.getProjectDescription());
		System.out.println("Start Date:"+project.getStartDate());
		System.out.println("Manager:"+project.getProjectManager().getEmpName());
		System.out.println("Team Details:");
		System.out.println("Team Name:"+project.getTeam().getTeamName());
		System.out.println("Size:"+project.getTeam().getTeamSize());
		System.out.println("Members:");
		project.getTeam().getEmployees().forEach(emp -> {
			System.out.println("Name:"+emp.getEmpName());
			System.out.println("Designation:"+emp.getDesignation());
			System.out.println("Email:"+emp.getContacts().getWorkEmailId());
			System.out.println("Address:"+emp.getContacts().getCurrentAddress().getAddress()+" City:"+emp.getContacts().getCurrentAddress().getCity());
		});
		System.out.println("################################################################################");
	}
	
	public void printProjectByDateRange(String startDate,String endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = sdf.parse(startDate);
		Date edate = sdf.parse(endDate);
		List<Project> projectList=projectService.getProjectByDateRange(sdate, edate);
		projectList.forEach(project -> {
			
			System.out.println("================ [ Project(#"+project.getProjectId()+") ] ===============");
			System.out.println("Project Id:"+project.getProjectId());
			System.out.println("Title:"+project.getProjectTitle());
			System.out.println("Description:"+project.getProjectDescription());
			System.out.println("Start Date:"+project.getStartDate());
			System.out.println("Manager:"+project.getProjectManager().getEmpName());
			System.out.println("Team Details:");
			System.out.println("Team Name:"+project.getTeam().getTeamName());
			System.out.println("Size:"+project.getTeam().getTeamSize());
			System.out.println("Members:");
			project.getTeam().getEmployees().forEach(emp -> {
				System.out.println("Name:"+emp.getEmpName());
				System.out.println("Designation:"+emp.getDesignation());
				System.out.println("Email:"+emp.getContacts().getWorkEmailId());
				System.out.println("Address:"+emp.getContacts().getCurrentAddress().getAddress()+" City:"+emp.getContacts().getCurrentAddress().getCity());
			});
			System.out.println("=========================================================================");
			
		});
		
	}
	
	public void printProjects() {
		List<Project> projectList=projectService.getProjects();
		projectList.forEach(project -> {
			
			System.out.println("************** [ Project(#"+project.getProjectId()+") ] **************");
			System.out.println("Project Id:"+project.getProjectId());
			System.out.println("Title:"+project.getProjectTitle());
			System.out.println("Description:"+project.getProjectDescription());
			System.out.println("Start Date:"+project.getStartDate());
			System.out.println("Manager:"+project.getProjectManager().getEmpName());
			System.out.println("Team Details:");
			System.out.println("Team Name:"+project.getTeam().getTeamName());
			System.out.println("Size:"+project.getTeam().getTeamSize());
			System.out.println("Members:");
			project.getTeam().getEmployees().forEach(emp -> {
				System.out.println("Name:"+emp.getEmpName());
				System.out.println("Designation:"+emp.getDesignation());
				System.out.println("Email:"+emp.getContacts().getWorkEmailId());
				System.out.println("Address:"+emp.getContacts().getCurrentAddress().getAddress()+" City:"+emp.getContacts().getCurrentAddress().getCity());
			});
			System.out.println("**********************************************************************");
			
		});
	}
	
	public void updateProject(Project project) {
		projectService.updateProject(project);
	}
	
	public void deleteProject(String projectId) {
		projectService.deleteProject(projectId);
	}
}
