package com.library_management.bookverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library_management.bookverse.model.Book;
import com.library_management.bookverse.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public List<Book> get(){
		return bookService.get();
	}
	
	@PostMapping("/book")
	public Book save(@RequestBody Book bookObj) {
		bookService.save(bookObj);
		return bookObj;
	}
	
	@GetMapping("/book/{book_id}")
	public Book get(@PathVariable int book_id) {
		Book bookObj = bookService.get(book_id);
		if(bookObj==null) {
			throw new RuntimeException("Book with id "+book_id+" is not found.");
		}
		return bookObj;
	}

	@DeleteMapping("/book/{book_id}")
	public String delete(@PathVariable int book_id) {
		bookService.delete(book_id);
		return "Book has been deleted with id "+ book_id;
	}
	
	@PutMapping("/book")
	public Book update(@RequestBody Book bookObj) {
		bookService.save(bookObj);
		return bookObj;
	}
}
