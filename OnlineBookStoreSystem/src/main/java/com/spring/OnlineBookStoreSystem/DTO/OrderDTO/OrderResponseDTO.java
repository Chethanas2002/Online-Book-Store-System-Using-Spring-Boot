package com.spring.OnlineBookStoreSystem.DTO.OrderDTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponseDTO {
	private int orderId;
    private float totalPrice;
    private LocalDate orderDate;
    private String status;
    private int userId;
    private String userName;
    private List<OrderItemResponseDTO> orderItems;
}
