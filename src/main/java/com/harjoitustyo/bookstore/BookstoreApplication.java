package com.harjoitustyo.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harjoitustyo.bookstore.model.AppUser;
import com.harjoitustyo.bookstore.model.AppUserRepository;
import com.harjoitustyo.bookstore.model.Book;
import com.harjoitustyo.bookstore.model.BookRepository;
import com.harjoitustyo.bookstore.model.Category;
import com.harjoitustyo.bookstore.model.CategoryRepository;

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
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository, AppUserRepository userRepository) {
	return (args) -> {
		//lisätään kategorioita
		Category kategoria1 =(new Category("kategoria1"));
		Category kategoria2 =(new Category("kategoria2"));

		categoryRepository.save(kategoria1);
        categoryRepository.save(kategoria2);
		//lisätty pari kirjaa
		Book book1 = new Book("Kirjan nimi", "kirjailija", 2025, "Isbn1111", 30, kategoria1);
		Book book2 = new Book("Kirjan nimi2", "eri kirjailija", 2000, "123456", 50.99, kategoria2);
	    //tallennetaan kirjat h2-kantaan
		bookRepository.save(book1);
		bookRepository.save(book2);

		//lisätään käyttäjiä
		AppUser user1 = new AppUser("user", "$2a$10$eLf3Po94URHnCmbtn18umebWxwlRI8EGmDVVL29SA2jYEpOj5Nj8y", "USER");
		AppUser user2 = new AppUser("admin", "$2a$10$HRMMAe0D4CtENoiGP8vUBOnIdO.COE914FcewdFgZXkgbPB5vUbPm", "ADMIN");
		userRepository.save(user1);
		userRepository.save(user2);

		for (Book book : bookRepository.findAll()){
			log.info(book.toString());
		}
	};
}

}
