package com.multids.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multids.example.app.entities.Book;

@Service
public interface BookService {

	public Book getBookById(String bookId);
	public List<Book> getAllBooks();
	public List<Book> getBookByName(String bookName);
	public List<Book> getBookBuAuthor(String author);
	public List<Book> getBookByPublisher(String publisher);
	public void createBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(String bookId);
	
}
