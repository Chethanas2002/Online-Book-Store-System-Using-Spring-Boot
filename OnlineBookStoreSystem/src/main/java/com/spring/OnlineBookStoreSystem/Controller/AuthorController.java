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

import com.spring.OnlineBookStoreSystem.DTO.AuthorDTO.AuthorRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.AuthorDTO.AuthorResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public List<AuthorResponseDTO> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/author/id/{id}")
    public Optional<AuthorResponseDTO> getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/author")
    public AuthorResponseDTO addAuthor(@RequestBody AuthorRequestDTO dto) {
        return authorService.addAuthor(dto);
    }

    @GetMapping("/author/name/{authorName}")
    public Optional<AuthorResponseDTO> getAuthorByAuthorName(@PathVariable String authorName) {
        return authorService.getAuthorByAuthorName(authorName);
    }

    @GetMapping("/author/partialname/{authorName}")
    public List<AuthorResponseDTO> getAuthorByPartialAuthorName(@PathVariable String authorName) {
        return authorService.getAuthorByPartialAuthorName(authorName);
    }

    @DeleteMapping("/author/del/{id}")
    public String deleteByAuthorId(@PathVariable int id) {
        return authorService.deleteByAuthorId(id);
    }
}
