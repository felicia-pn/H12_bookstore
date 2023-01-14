package de.unikoeln.se.bookstore2.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String author;
	private Integer bookYear;
	private Integer price;
	
	public Book() {}
	
	
	public Book(String name, String author, Integer year, Integer price) {
		this.name=name;
		this.author=author;
		this.bookYear=year;
		this.price=price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getBookYear() {
		return bookYear;
	}

	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}	

}
