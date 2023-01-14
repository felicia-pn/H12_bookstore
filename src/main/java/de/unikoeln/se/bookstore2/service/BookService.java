package de.unikoeln.se.bookstore2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import de.unikoeln.se.bookstore2.repository.BookRepo;
import de.unikoeln.se.bookstore2.datamodel.Book;


@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> findBooks() {
		return bookRepo.findAll();
	}
	
	public Optional<Book> fetchBook(int id) {
		return bookRepo.findById(id);
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public boolean deleteBook(int id) {
		boolean status;
		
		try {
			bookRepo.deleteById(id);
			status = true;
		} catch (Exception e) {
			status = false; 
		} 
		return status;
	}
	
	public Book getOldest() {
		return bookRepo.findAll(Sort.by(Sort.Direction.ASC, "bookYear")).get(0);
	}
	
	public Book getNewest() {
		return bookRepo.findAll(Sort.by(Sort.Direction.DESC, "bookYear")).get(0);
	}

}
