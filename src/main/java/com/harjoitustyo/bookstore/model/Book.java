package com.harjoitustyo.bookstore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;



@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @NotEmpty(message = "Book's title cannot be empty")
    @Size(min = 1, max = 250)
    private String title;

    @NotEmpty(message  = "Authors name cannot be empty")
    @Size(min = 1, max = 250)
    private String author;

    @Min(value = 0, message = "Year cannot be empty or negative")
    private int publicationYear;

    @NotEmpty(message = "ISBN cannot be empty")
    @Size(min = 1, max = 20)
    private String isbn;

    @Min(value = 0, message= "Price cannot be empty or negative")
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    

    public Book() {

    }
     public Book(String title, String author, int publicationYear, String isbn, double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;

        
    }
     public Long getId() {
        return id;
     }
     public String getTitle() {
         return title;
     }
     public void setTitle(String title) {
         this.title = title;
     }
     public String getAuthor() {
         return author;
     }
     public void setAuthor(String author) {
         this.author = author;
     }
     public int getPublicationYear() {
         return publicationYear;
     }
     public void setPublicationYear(int publicationYear) {
         this.publicationYear = publicationYear;
     }
     public String getIsbn() {
         return isbn;
     }
     public void setIsbn(String isbn) {
         this.isbn = isbn;
     }
     public double getPrice() {
         return price;
     }
     public void setPrice(double price) {
         this.price = price;
     }
     public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
     @Override
     public String toString() {
        return "Book [id= " + id + ", title= " + title + ", author= " + author + ", Year= " + publicationYear + "Isbn= " + isbn + ", Price=" + price +" , Category=" + category.getName() + "]";
     }

    
    
}

