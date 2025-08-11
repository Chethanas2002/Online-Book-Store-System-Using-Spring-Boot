package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Author;
import com.spring.OnlineBookStoreSystem.Model.Book;
import com.spring.OnlineBookStoreSystem.Repository.AuthorRepository;
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
		return bookRepo.findBookByBookNameContainingIgnoreCase(name);
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
	
	
	
	@Autowired
    private AuthorRepository authorRepository;

    public void linkAuthorToBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Set the relation
        book.setAuthor(author);

        // Optional: keep bidirectional sync
//        if (!author.getBook().contains(book)) {
//            author.getBook().add(book);
//        }

        bookRepo.save(book);
        authorRepository.save(author); // not always required if cascade is set
    }
}
