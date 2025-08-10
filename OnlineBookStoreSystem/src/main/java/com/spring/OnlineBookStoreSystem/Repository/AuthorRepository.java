package com.spring.OnlineBookStoreSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	
	public List<Author> findByAuthorNameLikeIgnoreCase(String authorName);

	
	public Optional<Author> findAuthorByAuthorNameIgnoreCase(String authorName);
	 

}
