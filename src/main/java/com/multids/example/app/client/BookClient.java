package com.multids.example.app.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multids.example.app.dao.BookDao;
import com.multids.example.app.entities.Book;

@Component
public class BookClient {

	@Autowired
	private BookDao bookDao;
	
	public void printAllBooks() {
		
		List<Book> booklist=bookDao.getAllBooks();
		
		booklist.forEach(book -> {
			System.out.println("==================== [ Book Details ] ===============");
			System.out.println("Book-Id:		"+book.getBookId());
			System.out.println("Book-Title:	"+book.getTitle());
			System.out.println("Author:	"+book.getAuthor());
			System.out.println("Publisher:	"+book.getPublisher());
			System.out.println("Issue-Date:	"+book.getIssueDate());
			System.out.println("=====================================================");
			});
	}
	
	public void printBookById(String bookId) {
		Book book=bookDao.getBookById(bookId);
		System.out.println("==================== [ BookId["+bookId+"] ] ===============");
		System.out.println("Book-Id:		"+book.getBookId());
		System.out.println("Book-Title:	"+book.getTitle());
		System.out.println("Author:	"+book.getAuthor());
		System.out.println("Publisher:	"+book.getPublisher());
		System.out.println("Issue-Date:	"+book.getIssueDate());
		System.out.println("=====================================================");
	}
	
	public void printBookByTitle(String title) {
		List<Book> booklist=bookDao.getBookByName(title);
		booklist.forEach(book -> {
			System.out.println("==================== [ Booktitle["+title+"] ] ===============");
			System.out.println("Book-Id:		"+book.getBookId());
			System.out.println("Book-Title:	"+book.getTitle());
			System.out.println("Author:	"+book.getAuthor());
			System.out.println("Publisher:	"+book.getPublisher());
			System.out.println("Issue-Date:	"+book.getIssueDate());
			System.out.println("=====================================================");
			});
		
	}
	
	public void printBookByAuthor(String auhtor) {
		List<Book> booklist=bookDao.getBookBuAuthor(auhtor);
		booklist.forEach(book -> {
			System.out.println("==================== [ BookAuhtor["+auhtor+"] ] ===============");
			System.out.println("Book-Id:		"+book.getBookId());
			System.out.println("Book-Title:	"+book.getTitle());
			System.out.println("Author:	"+book.getAuthor());
			System.out.println("Publisher:	"+book.getPublisher());
			System.out.println("Issue-Date:	"+book.getIssueDate());
			System.out.println("=====================================================");
			});
		
	}
	
	public void printBookByPublisher(String publisher) {
		List<Book> bookList=bookDao.getBookByPublisher(publisher);
		bookList.forEach(book -> {
			System.out.println("==================== [ BookPublisher["+publisher+"] ] ===============");
			System.out.println("Book-Id:		"+book.getBookId());
			System.out.println("Book-Title:	"+book.getTitle());
			System.out.println("Author:	"+book.getAuthor());
			System.out.println("Publisher:	"+book.getPublisher());
			System.out.println("Issue-Date:	"+book.getIssueDate());
			System.out.println("=====================================================");
			});
	}
	
	public void createNewBook(Book book) {
		bookDao.createBook(book);
	}
	
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	
	public void deleteBook(String bookId) {
		bookDao.deleteBook(bookId);
	}
}
