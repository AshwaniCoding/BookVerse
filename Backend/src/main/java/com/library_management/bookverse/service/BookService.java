package com.library_management.bookverse.service;

import java.util.List;

import com.library_management.bookverse.model.Book;


public interface BookService {
	
	List<Book> get();
	
	Book get(int book_id);
	
	void save(Book book);
	
	void delete(int book_id);
	
}
