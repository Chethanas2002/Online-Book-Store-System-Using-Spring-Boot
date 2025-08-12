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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.BookDTO.BookRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.BookDTO.BookResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookResponseDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable int id) {
        Optional<BookResponseDTO> dto = bookService.getBookById(id);
        return dto.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BookResponseDTO addBook(@RequestBody BookRequestDTO dto) {
        return bookService.addBook(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return bookService.deleteById(id);
    }

    // Link Author
    @PutMapping("/{bookId}/author/{authorId}")
    public ResponseEntity<String> linkAuthorToBook(
            @PathVariable int bookId,
            @PathVariable int authorId) {
        bookService.linkAuthorToBook(bookId, authorId);
        return ResponseEntity.ok("Author linked to book successfully");
    }

    // Link Category
    @PutMapping("/{bookId}/category/{categoryId}")
    public ResponseEntity<String> linkCategoryToBook(
            @PathVariable int bookId,
            @PathVariable int categoryId) {
        bookService.linkCategoryToBook(bookId, categoryId);
        return ResponseEntity.ok("Category linked to book successfully");
    }
}