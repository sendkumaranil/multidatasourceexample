package com.multids.example.app.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.multids.example.app.documents.Address;
import com.multids.example.app.documents.Contacts;
import com.multids.example.app.documents.Employee;
import com.multids.example.app.documents.Team;

public class CreateProjectData {

	public Team createTeam() {
			
			List<Employee> employees=new ArrayList<>();
			employees.add(createManager());
			employees.add(createTeamLead());
			employees.add(seniorDeveloper());
			employees.add(createDeveloper2());
			
			Team team=new Team();
			team.setTeamId("T10001");
			team.setTeamName("Avengers Coders");
			team.setEmployees(employees);
		
			return team;
		}

	public Employee createManager() {
		
		Address currentAdd=new Address();
		currentAdd.setAddress("Virat Nagare,House No 56,7th Main,4th Cross");
		currentAdd.setLocality("Bomanhalli");
		currentAdd.setCity("Bangalore");
		currentAdd.setState("Karnataka");
		currentAdd.setPincode("560068");
		
		Address permanentAdd=new Address();
		permanentAdd.setAddress("Laxmi Vihar,Ext 45,House No 123");
		permanentAdd.setLocality("South Delhi");
		permanentAdd.setCity("New Delhi");
		permanentAdd.setState("New Delhi");
		permanentAdd.setPincode("110022");
		
		Contacts managerContact=new Contacts();
		managerContact.setWorkphoneNumber("+919916727280");
		managerContact.setHomephoneNumber("+919090808070");
		managerContact.setWorkEmailId("kuldeep.singh@mycompany.com");
		managerContact.setPersonalEmailId("kuldeep.singh@gmail.com");
		managerContact.setCurrentAddress(currentAdd);
		managerContact.setPermanentAddress(permanentAdd);
		
		Employee projectManager=new Employee();
		projectManager.setEmpId("E10001");
		projectManager.setEmpName("Kuldeep Singh");
		projectManager.setJoinDate(new Date());
		projectManager.setContacts(managerContact);
		projectManager.setDesignation("Delivery Manager");
		
		return projectManager;
	}
	
	public Employee createTeamLead() {
		
		Address currentAdd=new Address();
		currentAdd.setAddress("Virat Nagar,House No 13,10th Main,7th Cross");
		currentAdd.setLocality("Bomanhalli");
		currentAdd.setCity("Bangalore");
		currentAdd.setState("Karnataka");
		currentAdd.setPincode("560068");
		
		Address permanentAdd=new Address();
		permanentAdd.setAddress("House No 56,Sector 15, Housing Board");
		permanentAdd.setLocality("Sector 15");
		permanentAdd.setCity("Gurugram");
		permanentAdd.setState("Haryana");
		permanentAdd.setPincode("122001");
		
		Contacts teamleadContact=new Contacts();
		teamleadContact.setWorkphoneNumber("+919916722847");
		teamleadContact.setHomephoneNumber("+919095858110");
		teamleadContact.setWorkEmailId("anil.verma@mycompany.com");
		teamleadContact.setPersonalEmailId("anil.verma@gmail.com");
		teamleadContact.setCurrentAddress(currentAdd);
		teamleadContact.setPermanentAddress(permanentAdd);
		
		Employee teamLead=new Employee();
		teamLead.setEmpId("E10002");
		teamLead.setEmpName("Anil Verma");
		teamLead.setDesignation("Team Lead");
		teamLead.setJoinDate(new Date());
		teamLead.setContacts(teamleadContact);
		return teamLead;
	}
	
	public Employee seniorDeveloper() {
		
		Address currentAdd=new Address();
		currentAdd.setAddress("Flat No 101,21st Cross,7th Main");
		currentAdd.setLocality("HSR Layout");
		currentAdd.setCity("Bangalore");
		currentAdd.setState("Karnataka");
		currentAdd.setPincode("560065");
		
		Address permanentAdd=new Address();
		permanentAdd.setAddress("Flat No 101,21st Cross,7th Main");
		permanentAdd.setLocality("HSR Layout");
		permanentAdd.setCity("Bangalore");
		permanentAdd.setState("Karnataka");
		permanentAdd.setPincode("560065");
		
		Contacts developer1Contact=new Contacts();
		developer1Contact.setWorkphoneNumber("+919916722945");
		developer1Contact.setHomephoneNumber("+919095857540");
		developer1Contact.setWorkEmailId("mukund_tripathi@mycompany.com");
		developer1Contact.setPersonalEmailId("mukund.tripathi@outlook.com");
		developer1Contact.setCurrentAddress(currentAdd);
		developer1Contact.setPermanentAddress(permanentAdd);
		
		Employee developer1=new Employee();
		developer1.setEmpId("E10003");
		developer1.setEmpName("Mukund Tripathi");
		developer1.setDesignation("Senior Developer");
		developer1.setJoinDate(new Date());
		developer1.setContacts(developer1Contact);
		
		return developer1;
		
	}
	
	public Employee createDeveloper2() {
			
			Address currentAdd=new Address();
			currentAdd.setAddress("Flat No 12,2nd Floor,12th Cross");
			currentAdd.setLocality("Marathalli");
			currentAdd.setCity("Bangalore");
			currentAdd.setState("Karnataka");
			currentAdd.setPincode("560061");
			
			Address permanentAdd=new Address();
			permanentAdd.setAddress("House No 12,Housing Board Colony");
			permanentAdd.setLocality("Hans Enclave");
			permanentAdd.setCity("Noida");
			permanentAdd.setState("UP");
			permanentAdd.setPincode("130012");
			
			Contacts developer2Contact=new Contacts();
			developer2Contact.setWorkphoneNumber("+919916896512");
			developer2Contact.setHomephoneNumber("+919095786543");
			developer2Contact.setWorkEmailId("vikash.goel@mycompany.com");
			developer2Contact.setPersonalEmailId("goel.vikash@yahoo.com");
			developer2Contact.setCurrentAddress(currentAdd);
			developer2Contact.setPermanentAddress(permanentAdd);
			
			Employee developer2=new Employee();
			developer2.setEmpId("E10004");
			developer2.setEmpName("Vikash Goel");
			developer2.setDesignation("Developer");
			developer2.setJoinDate(new Date());
			developer2.setContacts(developer2Contact);
			
			return developer2;
			
		}
}
