package com.library_management.bookverse.dao;

import java.util.List;

import com.library_management.bookverse.model.Book;


public interface BookDAO {

	List<Book> get();
	
	Book get(int book_id);
	
	void save(Book book);
	
	void delete(int book_id);
	
}
