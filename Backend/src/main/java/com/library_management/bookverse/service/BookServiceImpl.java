package com.library_management.bookverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management.bookverse.dao.BookDAO;
import com.library_management.bookverse.model.Book;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Transactional
	@Override
	public List<Book> get() {
		return bookDAO.get();
	}
	
	@Transactional
	@Override
	public Book get(int book_id) {
		return bookDAO.get(book_id);
	}
	
	@Transactional
	@Override
	public void save(Book book) {
		bookDAO.save(book);
		
	}
	
	@Transactional
	@Override
	public void delete(int book_id) {
		bookDAO.delete(book_id);
		
	}



}
