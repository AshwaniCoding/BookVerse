package com.library_management.bookverse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library_management.bookverse.model.Book;

import jakarta.persistence.EntityManager;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Book> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Book> query = currentSession.createQuery("from Book", Book.class);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public Book get(int book_id) {
		Session currentSession = entityManager.unwrap(Session.class);
	    return currentSession.get(Book.class, book_id);
	}

	@Override
	public void save(Book book) {
		Session currentSession = entityManager.unwrap(Session.class);
	    currentSession.saveOrUpdate(book);		
	}

	@Override
	public void delete(int book_id) {
		Session currentSession = entityManager.unwrap(Session.class);
	    Book bookObj = currentSession.get(Book.class, book_id);
	    if (bookObj != null) {
	        currentSession.delete(bookObj);
	    }		
	}


}
