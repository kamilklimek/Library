package pl.maniaq.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.maniaq.library.model.Book;
import pl.maniaq.library.service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class LibraryApplication{


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);



	}
}
