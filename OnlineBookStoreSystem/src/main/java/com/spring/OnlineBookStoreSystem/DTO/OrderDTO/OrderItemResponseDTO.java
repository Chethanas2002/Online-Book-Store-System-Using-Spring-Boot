package com.spring.OnlineBookStoreSystem.DTO.OrderDTO;

import lombok.Data;

@Data
public class OrderItemResponseDTO {
	private int orderItemId;
	private int quantity;
	private float price;
	private int bookId;
	private String bookTitle;
}
