package com.example.springadvanced.repository;

import com.example.springadvanced.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//     findBy + PropertyName
//     Property must exist in book.java
//     AuthorName is the property but, Author is not the property
//     Solution: Annotate the method declaration by Query
    List<Book> findByAuthorName(String name);

    List<Book> findByCost(int cost);

    Book findById(int id);

//    List<Book> findByAuthor(String name); // WRONG!!!

    // case sensitive
    @Query(value = "select * from book b where b.author_name=:my_name", nativeQuery = true)
    List<Book> findByAuthor(String my_name);

    // case sensitive
    @Query(value = "select b from Book b where b.authorName=:authors_name")
    List<Book> findByAuthors(String authors_name);
}
