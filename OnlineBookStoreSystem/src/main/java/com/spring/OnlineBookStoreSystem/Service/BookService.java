package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Book;
import com.spring.OnlineBookStoreSystem.Repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Optional<Book> getBookById(int id){
		return bookRepo.findById(id);
	}
	
	public Optional<Book> getBookByBookName(String name){
		return bookRepo.findBookByBookNameIgnoreCase(name);
	}
	
	public List<Book> getBookByPartialBookName(String name){
		return bookRepo.findBookByBookNameLikeIgnoreCase(name);
	}

	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public String deleteById(int id) {
		if(!bookRepo.existsById(id)) {
			return "Book not found";
		}
		bookRepo.deleteById(id);
		return "Book deleted successfully";
	}
}
