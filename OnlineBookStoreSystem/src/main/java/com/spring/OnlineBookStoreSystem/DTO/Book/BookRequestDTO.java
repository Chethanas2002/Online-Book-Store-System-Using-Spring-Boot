package com.spring.OnlineBookStoreSystem.DTO.Book;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookRequestDTO {
	private String bookName;
    private float price;
    private int stock;
    private String description;
    private LocalDate releaseDate;
}
