package com.multids.example.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multids.example.app.dao.BookDao;
import com.multids.example.app.entities.Book;
import com.multids.example.app.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book getBookById(String bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public List<Book> getBookByName(String bookName) {
		return bookDao.getBookByName(bookName);
	}

	@Override
	public List<Book> getBookBuAuthor(String author) {
		return bookDao.getBookBuAuthor(author);
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) {
		return bookDao.getBookByPublisher(publisher);
	}

	@Override
	public void createBook(Book book) {
		bookDao.createBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public void deleteBook(String bookId) {
		bookDao.deleteBook(bookId);
	}

}
