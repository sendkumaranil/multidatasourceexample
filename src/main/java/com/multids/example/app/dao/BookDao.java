package com.multids.example.app.dao;

import java.util.List;

import com.multids.example.app.entities.Book;

public interface BookDao {

	public Book getBookById(String bookId);
	public List<Book> getAllBooks();
	public List<Book> getBookByName(String bookName);
	public List<Book> getBookBuAuthor(String author);
	public List<Book> getBookByPublisher(String publisher);
	public void createBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(String bookId);
}
