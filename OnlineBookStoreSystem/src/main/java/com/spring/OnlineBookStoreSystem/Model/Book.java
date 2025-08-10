package com.spring.OnlineBookStoreSystem.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
	private float price;
	private int stock;
	private String description;
	private LocalDate releaseDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	@JsonManagedReference
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "authorId")
	@JsonManagedReference
	private Author author;
}
