package com.spring.OnlineBookStoreSystem.DTO.CartDTO;

import java.util.List;

import lombok.Data;

@Data
public class CartResponseDTO {
	private int cartId;
    private int userId;
    private String userName;
    private List<Integer> cartItemIds;
}
