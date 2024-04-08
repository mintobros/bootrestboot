package com.rest.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.rest.api.entities.Book;
import com.rest.api.helper.SameAuthorException;

@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static {
		
		  list.add(new Book(10, "Servlet", "Quraishi")); 
		  list.add(new Book(11, "Jsp","XYZ")); 
		  list.add(new Book(12, "Spring", "Ahmad")); 
		  list.add(new Book(13,"Servlet Security", "Nigar"));
		 
	}

	//Get all Books....
	public List<Book> getAllBooks() {
		
		return list;
	}
	
	//Get Single Book....
	public Book getBookById(int id) {
		
		Book book=null;
		try {
			book  = list.stream().filter(e->e.getId()==id).findFirst().get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	
	
	//Adding The Book....
	public Book addBook(Book book) {
		
		try {
			Stream<Book> filter = list.stream().filter(e->e.getAuthor() == book.getAuthor());
			throw new SameAuthorException("Author already there..Try new authorName");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SameAuthorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//list.add(book);
		return book;
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
