package com.spring.OnlineBookStoreSystem.DTO.CartItemDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequestDTO {
	
    private int quantity;
    private float price;
    private int cartId;
    private int bookId;
}
