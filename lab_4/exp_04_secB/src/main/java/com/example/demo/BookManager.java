package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManager {
	@Autowired
	
	BookRepository repository;
	
	public List<Book> getAllBook() {
		return repository.findAll();	
	}
	
	public Book getBookById(Long id) {
		return repository.findById(id).get();
	}
	
	public void saveBook(Book book) {
		repository.save(book);
	}
	
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
}
