package de.unikoeln.se.bookstore2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import de.unikoeln.se.bookstore2.datamodel.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
