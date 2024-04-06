package com.rest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entities.Book;
import com.rest.api.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		System.out.println("First Book");
		
//		Book book=new Book();
//		book.setId(1);
//		book.setTitle("Java");
//		book.setAuthor("Vivek Sir");
//		
		System.out.println(this.bookService.getAllBooks());
		return this.bookService.getAllBooks();
		
	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		
		return this.bookService.getBookById(id);
	} 
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		
		 this.bookService.addBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		System.out.println("Deleted");
		this.bookService.deleteBook(bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		
		this.bookService.updateBook(book, bookId);
		return book;
	}
	
	
}
