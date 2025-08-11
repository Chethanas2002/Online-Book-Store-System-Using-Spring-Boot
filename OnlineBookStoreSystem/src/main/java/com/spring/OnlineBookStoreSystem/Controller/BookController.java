package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.Model.Book;
import com.spring.OnlineBookStoreSystem.Service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	@GetMapping("/bk")
	public String greet() {
		return "Greet form Book";
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/book/id/{id}")
	public Optional<Book> getBookById(@PathVariable int id){
		return bookService.getBookById(id);
	}
	
	@GetMapping("/book/name/{name}")
	public Optional<Book> getBookByBookName(@PathVariable String name){
		return bookService.getBookByBookName(name);
	}
	
	
	@GetMapping("/book/partialname/{name}")
	public List<Book> getBookByPartialBookName(@PathVariable String name){
		return bookService.getBookByPartialBookName(name);
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public String deleteById(@PathVariable int id) {
		
		return bookService.deleteById(id);
	}
	
	
	
	@PutMapping("/books/{bookId}/author/{authorId}")
	public ResponseEntity<String> linkAuthorToBook(
	        @PathVariable int bookId,
	        @PathVariable int authorId) {
	    bookService.linkAuthorToBook(bookId, authorId);
	    return ResponseEntity.ok("Author linked to book successfully");
	}

	
}
