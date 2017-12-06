package com.cadence.Books.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cadence.Books.models.Book;
import com.cadence.Books.service.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    public BooksController(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
	    public String books(Model model) {
		List<Book> books= bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
		
		  @PostMapping("/books/new")
		    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		        if (result.hasErrors()) {
		            return "newBook.jsp";
		        }else{
		            // Add the book
		            return "redirect:/books";
		        }
		    }
    }
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "editBook.jsp";
        }else{
            bookService.updateBook(id, book);
            return "redirect:/books";
        }
}
