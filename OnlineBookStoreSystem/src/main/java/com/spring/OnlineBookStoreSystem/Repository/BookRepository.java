package com.spring.OnlineBookStoreSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Optional<Book> findBookByBookNameIgnoreCase(String bookName);
	
	public List<Book> findBookByBookNameContainingIgnoreCase(String bookName);
}
