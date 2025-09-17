package com.harjoitustyo.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.harjoitustyo.bookstore.model.Book;
import com.harjoitustyo.bookstore.model.BookRepository;



@Controller

public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    @GetMapping("/booklist")
    public String getAllBooks(Model model) {
        log.info("getAllBooks...");
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String openAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        log.info("CONTROLLER: Save book: "+ book);
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        log.info("Delete book which id: " + id);
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model){
        log.info("Edit book which id:" + id);
        model.addAttribute("editBook", bookRepository.findById(id));
        return "editBook"; 
    }
    @PostMapping("/saveEditedBook")
    public String saveEditedBook(Book book) {
        log.info("CONTROLLER: Save edited book " + book);
        bookRepository.save(book);
        return "redirect:/booklist";
}

}
