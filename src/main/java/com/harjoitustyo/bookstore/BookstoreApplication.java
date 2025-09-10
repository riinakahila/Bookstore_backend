package com.harjoitustyo.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harjoitustyo.bookstore.model.Book;
import com.harjoitustyo.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    private final BookRepository bookRepository;

    BookstoreApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		//lisätty pari kirjaa
		Book book1 = new Book("Kirjan nimi", "kirjailija", 2025, "Isbn1111", 30);
		Book book2 = new Book("Kirjan nimi2", " eri kirjailija", 2000, "123456", 50.99);
	    //tallennetaan kirjat h2-kantaan
		bookRepository.save(book1);
		bookRepository.save(book2);

		for (Book book : bookRepository.findAll()){
			log.info(book.toString());
		}
	};
}

}
