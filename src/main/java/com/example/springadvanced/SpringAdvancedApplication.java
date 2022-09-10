package com.example.springadvanced;

import com.example.springadvanced.model.Book;
import com.example.springadvanced.model.BookCategory;
import com.example.springadvanced.repository.BookCategoryRepository;
import com.example.springadvanced.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringAdvancedApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
//		bookRepository.create();

		// do starter work
		// remove temp files
		// clean up the disk
		// done only once

//		bookCategoryRepository.save(new BookCategory("Programming Languages"));

		Book b1 = new Book("Intro to HTML", "Paul", 100,1);
		Book b2 = new Book("Intro to CSS", "Albert", 200, 1);

		Set<Book> bookList = new HashSet<>();
		bookList.add(b1);
		bookList.add(b2);

		bookRepository.saveAll(bookList);
//		bookCategoryRepository.save(new BookCategory("Non Programming Languages", bookList));

//		System.out.println(bookRepository.findByAuthorName("Anurag"));
//		System.out.println(bookRepository.findByCost(30));
//		System.out.println(bookRepository.findById(2));
//		System.out.println(bookRepository.findByAuthor("Anurag"));
//		System.out.println(bookRepository.findByAuthors("AP"));
	}
}