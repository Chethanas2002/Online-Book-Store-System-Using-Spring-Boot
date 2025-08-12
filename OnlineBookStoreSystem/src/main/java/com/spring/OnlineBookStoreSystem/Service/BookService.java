package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.BookDTO.BookRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.BookDTO.BookResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Author;
import com.spring.OnlineBookStoreSystem.Model.Book;
import com.spring.OnlineBookStoreSystem.Model.Category;
import com.spring.OnlineBookStoreSystem.Repository.AuthorRepository;
import com.spring.OnlineBookStoreSystem.Repository.BookRepository;
import com.spring.OnlineBookStoreSystem.Repository.CategoryRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    // Convert Entity -> ResponseDTO
    private BookResponseDTO convertToResponseDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setBookId(book.getBookId());
        dto.setBookName(book.getBookName());
        dto.setPrice(book.getPrice());
        dto.setStock(book.getStock());
        dto.setDescription(book.getDescription());
        dto.setReleaseDate(book.getReleaseDate());
        dto.setAuthorName(book.getAuthor() != null ? book.getAuthor().getAuthorName() : null);
        dto.setCategoryName(book.getCategory() != null ? book.getCategory().getCategoryName() : null);
        return dto;
    }

    public List<BookResponseDTO> getAllBooks() {
        return bookRepo.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookResponseDTO> getBookById(int id) {
        return bookRepo.findById(id)
                .map(this::convertToResponseDTO);
    }

    public BookResponseDTO addBook(BookRequestDTO dto) {
        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setPrice(dto.getPrice());
        book.setStock(dto.getStock());
        book.setDescription(dto.getDescription());
        book.setReleaseDate(dto.getReleaseDate());

        Book savedBook = bookRepo.save(book);
        return convertToResponseDTO(savedBook);
    }

    public String deleteById(int id) {
        if (!bookRepo.existsById(id)) {
            return "Book not found";
        }
        bookRepo.deleteById(id);
        return "Book deleted successfully";
    }

    public void linkAuthorToBook(int bookId, int authorId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);
        bookRepo.save(book);
    }

    public void linkCategoryToBook(int bookId, int categoryId) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        book.setCategory(category);
        bookRepo.save(book);
    }
}