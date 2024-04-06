package com.rest.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.rest.api.entities.Book;

@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book(10, "Servlet", "Quraishi"));
		list.add(new Book(11, "Jsp", "XYZ"));
		list.add(new Book(12, "Spring", "Ahmad"));
		list.add(new Book(13, "Servlet Security", "Nigar"));
	}

	//Get all Books....
	public List<Book> getAllBooks() {
		
		return list;
	}
	
	//Get Single Book....
	public Book getBookById(int id) {
		
		Book book=null;
		book  = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	
	
	//Adding The Book....
	public void addBook(Book book) {
		list.add(book);
	}
	
	//Deleting the Book....
	public void deleteBook(int bid) {
		list=list.stream().filter(book ->book.getId() != bid).collect(Collectors.toList());
	}
	
	
	//Updating The Book....
	public void updateBook(Book book, int bookId) {
		list=list.stream().map(b -> {
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
	
}
