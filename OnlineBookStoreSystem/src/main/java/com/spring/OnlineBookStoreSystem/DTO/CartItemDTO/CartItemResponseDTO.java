package com.spring.OnlineBookStoreSystem.DTO.CartItemDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponseDTO {
	private int cartItemsId;
    private int quantity;
    private float price;
    private int cartId;
    private int bookId;
    private String bookName;
}
