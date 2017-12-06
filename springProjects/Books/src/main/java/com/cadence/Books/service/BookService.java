package com.cadence.Books.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cadence.Books.models.Book;

@Service
public class BookService {
	ArrayList<Book> books = new ArrayList(Arrays.asList(
		 new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
         new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
         new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
         new Book("The Odyssey", "Ancient Greek epic poem", "english", 475),
         new Book("The Rabbit's Adventures", "Miffy's life", "English", 300)
         ));
 

	public List<Book> allBooks(){
		return books;
	}
	
	 public void addBook(Book book) {
	        books.add(book);
	    }
	 
	  public void updateBook(int id, Book book) {
	        if (id < books.size()){
	            books.set(id, book);
	        }

}
