package com.example.springadvanced.model;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;

@Entity
public class BookCategory { // Parent - One (BookCategory) corresponds to Many (Book) Mapping
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    // Set used due One to Many Mapping
    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookCategory(String name) {
        this.name = name;
    }

    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
//        this.books.forEach(x -> x.setBookCategory(this));

        for (Book book : books) {
            book.setBookCategory(this);
        }
    }

    public BookCategory() {
    }
}
