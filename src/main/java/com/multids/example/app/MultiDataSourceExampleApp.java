package com.multids.example.app;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
/**
 * @author anilkumar
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.multids.example.app.client.BookClient;
import com.multids.example.app.client.EmployeeClient;
import com.multids.example.app.entities.Book;
import com.multids.example.app.model.Employee;

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
	
	public static void main(String[] args) {
		SpringApplication.run(MultiDataSourceExampleApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
		
	}
}
