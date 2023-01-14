package de.unikoeln.se.bookstore2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import de.unikoeln.se.bookstore2.datamodel.Book;
import de.unikoeln.se.bookstore2.service.BookService;

@RequestMapping("/bookStore")
@RestController
public class BookController {
	
	@Autowired
	BookService bookSer;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		books = bookSer.findBooks();
		
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		return new ResponseEntity<>(bookSer.fetchBook(id).get(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getOldest")
	public ResponseEntity<Book> getOldestBook() {
		return new ResponseEntity<>(bookSer.getOldest(), HttpStatus.OK); 
	}
	
	@GetMapping("/getNewest")
	public ResponseEntity<Book> getMostRecentBook() {
		return new ResponseEntity<>(bookSer.getNewest(), HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		bookSer.addBook(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> removeBookById(@PathVariable int id) {
		Book book = bookSer.fetchBook(id).get();
		
		if(bookSer.deleteBook(id)) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
