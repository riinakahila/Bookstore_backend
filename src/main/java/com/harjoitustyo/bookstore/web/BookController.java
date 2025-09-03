package com.harjoitustyo.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.harjoitustyo.bookstore.domain.Book;


@Controller

public class BookController {

     public static List<Book> books = new ArrayList<>();

    @GetMapping("/index")
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        return "books";
    }
    

}
