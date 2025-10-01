package com.harjoitustyo.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.harjoitustyo.bookstore.model.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import com.harjoitustyo.bookstore.model.Category;



@Controller
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categoryList")
    public String showCategories(Model model) {
        log.info("Fetching all categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "/categoryList";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }
    
    
    
}
