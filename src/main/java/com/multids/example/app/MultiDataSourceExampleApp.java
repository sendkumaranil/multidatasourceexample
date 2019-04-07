package com.multids.example.app;
import java.util.Date;

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

import com.multids.example.app.client.BookClient;
import com.multids.example.app.entities.Book;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class,
		MongoAutoConfiguration.class})
public class MultiDataSourceExampleApp implements CommandLineRunner{

	@Autowired
	private BookClient bookClient;
	
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
	}
	
	
}
