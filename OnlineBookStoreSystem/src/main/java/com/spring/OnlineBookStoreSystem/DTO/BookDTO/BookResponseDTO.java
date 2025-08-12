package com.spring.OnlineBookStoreSystem.DTO.BookDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookResponseDTO {
	private int bookId;
    private String bookName;
    private float price;
    private int stock;
    private String description;
    private LocalDate releaseDate;
    private String categoryName;
    private String authorName;
}
