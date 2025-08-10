package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Author;
import com.spring.OnlineBookStoreSystem.Repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAllAuthor(){
		return authorRepo.findAll();
	}
	
	public Optional<Author> getAuthorById(int id){
		return authorRepo.findById(id);
	}
	
	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	public Optional<Author> getAuthorByAuthorName(String authorName){
		return authorRepo.findAuthorByAuthorNameIgnoreCase(authorName);
	}
	
	public List<Author> getAuthorByPartialAuthorName(String authorName){
		return authorRepo.findByAuthorNameLikeIgnoreCase(authorName);
	}
	
	public String deleteByAuthorId(int id) {
		if(!authorRepo.existsById(id)) {
			return "Author not found";
		}
		authorRepo.deleteById(id);
		return "Author deleted successfully";
	}
	
}
