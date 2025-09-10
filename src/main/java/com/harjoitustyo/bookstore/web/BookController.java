package com.harjoitustyo.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.harjoitustyo.bookstore.model.Book;
import com.harjoitustyo.bookstore.model.BookRepository;



@Controller

public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @GetMapping("/booklist")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("add")
    public String openAddBookForm(Model model) {
        model.addAttribute("kirja", new Book());
        return "addBook";
    }
    
    

}
