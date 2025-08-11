package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.AuthorDTO.AuthorRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.AuthorDTO.AuthorResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.Author;
import com.spring.OnlineBookStoreSystem.Repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;

    public List<AuthorResponseDTO> getAllAuthor() {
        return authorRepo.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public Optional<AuthorResponseDTO> getAuthorById(int id) {
        return authorRepo.findById(id)
                .map(this::mapToResponseDTO);
    }

    public AuthorResponseDTO addAuthor(AuthorRequestDTO dto) {
        Author author = new Author();
        author.setAuthorName(dto.getAuthorName());
        Author saved = authorRepo.save(author);
        return mapToResponseDTO(saved);
    }

    public Optional<AuthorResponseDTO> getAuthorByAuthorName(String authorName) {
        return authorRepo.findAuthorByAuthorNameIgnoreCase(authorName)
                .map(this::mapToResponseDTO);
    }

    public List<AuthorResponseDTO> getAuthorByPartialAuthorName(String authorName) {
        return authorRepo.findByAuthorNameLikeIgnoreCase(authorName)
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    public String deleteByAuthorId(int id) {
        if (!authorRepo.existsById(id)) {
            return "Author not found";
        }
        authorRepo.deleteById(id);
        return "Author deleted successfully";
    }

    // Helper method to convert Entity -> DTO
    private AuthorResponseDTO mapToResponseDTO(Author author) {
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorId(author.getAuthorId());
        dto.setAuthorName(author.getAuthorName());
        return dto;
    }
}
