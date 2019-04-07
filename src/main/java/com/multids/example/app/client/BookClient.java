package com.multids.example.app.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.multids.example.app.entities.Book;
import com.multids.example.app.service.BookService;

@Component
public class BookClient {

	@Autowired
	private BookService bookService;
	
	public void printAllBooks() {
		
		List<Book> booklist=bookService.getAllBooks();
		
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
		Book book=bookService.getBookById(bookId);
		System.out.println("==================== [ BookId["+bookId+"] ] ===============");
		System.out.println("Book-Id:		"+book.getBookId());
		System.out.println("Book-Title:	"+book.getTitle());
		System.out.println("Author:	"+book.getAuthor());
		System.out.println("Publisher:	"+book.getPublisher());
		System.out.println("Issue-Date:	"+book.getIssueDate());
		System.out.println("=====================================================");
	}
	
	public void printBookByTitle(String title) {
		List<Book> booklist=bookService.getBookByName(title);
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
		List<Book> booklist=bookService.getBookBuAuthor(auhtor);
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
		List<Book> bookList=bookService.getBookByPublisher(publisher);
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
		bookService.createBook(book);
	}
	
	public void updateBook(Book book) {
		bookService.updateBook(book);
	}
	
	public void deleteBook(String bookId) {
		bookService.deleteBook(bookId);
	}
}
