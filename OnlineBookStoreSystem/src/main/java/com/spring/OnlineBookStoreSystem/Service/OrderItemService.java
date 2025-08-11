package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.OrderItem;
import com.spring.OnlineBookStoreSystem.Repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository oItemRepo;
	
	public List<OrderItem> getAllOrderItem(){
		return oItemRepo.findAll();
	}
	
	public Optional<OrderItem> getOrderItemById(int id){
		return oItemRepo.findById(id);
	}
	
	public OrderItem addOrderItem(OrderItem orderItem) {
		return oItemRepo.save(orderItem);
	}
	
	public String deleteOrderItemById(int id) {
		if(!oItemRepo.existsById(id)) {
			return "Order item not found";
		}
		oItemRepo.deleteById(id);
		return "Order item deleted successfully";
	}
	
}
