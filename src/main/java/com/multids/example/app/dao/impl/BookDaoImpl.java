package com.multids.example.app.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multids.example.app.dao.BookDao;
import com.multids.example.app.entities.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Book getBookById(String bookId) {
		return sessionFactory.getCurrentSession().get(Book.class, bookId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookByName(String bookName) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Book where title=:booktitle");
		query.setParameter("booktitle", bookName);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookBuAuthor(String author) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Book where author=:authorname");
		query.setParameter("authorname", author);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookByPublisher(String publisher) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Book where publisher=:publisher");
		query.setParameter("publisher", publisher);
		return query.getResultList();
	}

	@Override
	public void createBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	public void deleteBook(String bookId) {
		Query query=sessionFactory.getCurrentSession().createQuery("delete from Book where bookId=:bookid");
		query.setParameter("bookid", bookId);
		query.executeUpdate();
	}

}
