package com.spring.OnlineBookStoreSystem.DTO.OrderDTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderRequestDTO {
	private float totalPrice;
    private LocalDate orderDate;
    private String status;
    private int userId; 
}
