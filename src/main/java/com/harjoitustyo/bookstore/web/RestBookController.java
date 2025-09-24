package com.harjoitustyo.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.harjoitustyo.bookstore.model.Book;
import com.harjoitustyo.bookstore.model.BookRepository;
import com.harjoitustyo.bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RestBookController {

    private static final Logger log = LoggerFactory.getLogger(RestBookController.class);

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public RestBookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/books")
    public List<Book>getAllBooks(){
        log.info("all books...");
        return bookRepository.findAll();
    }
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        log.info("book id " + id);
        return bookRepository.findById(id);
    }
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    
}
