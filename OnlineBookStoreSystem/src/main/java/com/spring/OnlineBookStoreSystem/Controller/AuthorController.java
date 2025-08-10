package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.Model.Author;
import com.spring.OnlineBookStoreSystem.Service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/auth")
	public String greet() {
		return "Greet fom author";
	}
	
	@GetMapping("/author")
	public List<Author> getAllAuthor(){
		return authorService.getAllAuthor();
	}
	
	@GetMapping("/author/id/{id}")
	public Optional<Author> getAuthorById(@PathVariable int id){
		return authorService.getAuthorById(id);
	}
	
	@PostMapping("/author")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@GetMapping("/author/name/{authorName}")
	public Optional<Author> getAuthorByAuthorName(@PathVariable String authorName){
		return authorService.getAuthorByAuthorName(authorName);
	}
	
	@GetMapping("/author/partialname/{authorName}")
	public List<Author> getAuthorByPartialAuthorName(@PathVariable String authorName){
		return authorService.getAuthorByPartialAuthorName(authorName);
	}
	
	@DeleteMapping("/author/del/{id}")
	public String deleteByAuthorId(@PathVariable int id) {
		return authorService.deleteByAuthorId(id);
	}
}
