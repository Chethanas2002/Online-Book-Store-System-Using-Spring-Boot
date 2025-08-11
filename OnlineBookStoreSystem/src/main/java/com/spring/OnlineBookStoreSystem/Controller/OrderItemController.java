package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.Model.OrderItem;
import com.spring.OnlineBookStoreSystem.Service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService oItemService;
	
	@GetMapping("/orderitems")
	public List<OrderItem> getAllOrderItem(){
		return oItemService.getAllOrderItem();
	}
	
	
	@GetMapping("/{id}")
	public Optional<OrderItem> getOrderItemById(@PathVariable int id){
		return oItemService.getOrderItemById(id);
	}
	
	@PostMapping("/orderitems")
	public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
		return oItemService.addOrderItem(orderItem);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteOrderItemById(@PathVariable int id) {
		
		return oItemService.deleteOrderItemById(id);
	}
}
