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
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private float totalPrice;
	private LocalDate orderDate;
	private String status;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
}
