package com.multids.example.app;
/**
 * @author anilkumar
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import com.multids.example.app.client.BookClient;
import com.multids.example.app.client.EmployeeClient;
import com.multids.example.app.client.ProjectClient;
import com.multids.example.app.documents.Project;
import com.multids.example.app.model.Employee;
import com.multids.example.app.utils.CreateProjectData;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class,
		MongoAutoConfiguration.class})
public class MultiDataSourceExampleApp implements CommandLineRunner{

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BookClient bookClient;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@Autowired
	private ProjectClient projectClient;
	
	public static void main(String[] args) {
		SpringApplication.run(MultiDataSourceExampleApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//MySql Database Example
		bookClient.printAllBooks();
		bookClient.printBookById("BIN00002");
		bookClient.printBookByTitle("C++ Fundamentals");
		bookClient.printBookByAuthor("Anil Kumar");
		bookClient.printBookByPublisher("XYZ Publishing");
		
		//Book book=new Book("BIN00004","Java Advance","Anil Kumar","XYZ Publishing",new Date());
		//bookClient.createNewBook(book);
		
		//Book book=new Book("BIN00004","Java Advance Concept","Anil Kumar","XYZ Publishing",new Date());
		//bookClient.updateBook(book);
		
		//bookClient.deleteBook("BIN00004");
		
		//H2 Database Example
		Employee employee=new Employee(1001,"Anil Kumar","anil.kumar@gmail.com","+918860543432");
		Employee employee2=new Employee(1002,"Amit Kumar","amit.kumar@gmail.com","+919960543432");
		Employee employee3=new Employee(1003,"Mandeep Singh","mandeep.singh@gmail.com","+918860543435");
		Employee employee4=new Employee(1004,"Suraj Tiwari","suraj.tiwari@gmail.com","+918860543432");
		Employee employee5=new Employee(1005,"Bhushan Thapar","bhushan.th@gmail.com","+917760543432");
		
		List<Employee> emplist=new ArrayList<>();
		emplist.add(employee);
		emplist.add(employee2);
		emplist.add(employee3);
		emplist.add(employee4);
		emplist.add(employee5);
		
		emplist.forEach(emp -> {
			employeeClient.createEmployee(emp);
		});
		
		employeeClient.printEmployees(1003);
		
		employeeClient.printEmployees();
		
		Employee employee6=new Employee(1004,"Suraj Tiwari","suraj.tiwari@outlook.com","+919960543432");
		
		employeeClient.updateEmployee(employee6);
		
		employeeClient.deleteEmployee(1005);
		
		employeeClient.printEmployees();
		
		//MongoDb Example
		CreateProjectData prjData=new CreateProjectData();
		
		Project project=new Project();
		project.setProjectId("PROJ10003");
		project.setProjectTitle("Enterprise Data Platform Interface");
		project.setProjectDescription("Provide data on demand");
		project.setStartDate(new Date());
		project.setProjectManager(prjData.createManager());
		project.setTeam(prjData.createTeam());
		
		//projectClient.createNewProject(project);
		
		projectClient.printProject("PROJ10001");
		
		projectClient.printProjectByTeamId("T10002");
		
		projectClient.printProjectByDateRange("2019-04-01", "2019-04-30");
		
		projectClient.printProjects();
		
		Project project2=new Project();
		project2.setProjectId("PROJ10002");
		project2.setTeam(prjData.updateTeam());
		
		projectClient.updateProject(project2);
		
		projectClient.printProject("PROJ10002");
		
		projectClient.deleteProject("PROJ10003");
		
		projectClient.printProjects();
	}
}
