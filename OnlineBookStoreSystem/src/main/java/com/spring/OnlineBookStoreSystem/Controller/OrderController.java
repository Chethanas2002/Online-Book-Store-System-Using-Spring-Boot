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

import com.spring.OnlineBookStoreSystem.Model.Orders;
import com.spring.OnlineBookStoreSystem.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/od")
	public String greet() {
		return "Greet from order controller";
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public Optional<Orders> getOrderById(@PathVariable int id){
		return orderService.getOrderById(id);
	}
	
	@PostMapping("/orders")
	public Orders addOrders(@RequestBody Orders order) {
		return orderService.addOrders(order);
	}
	
	@DeleteMapping("/orders/{id}")
	public String deleteOrderById(@PathVariable int id) {
		
		return orderService.deleteOrderById(id);
	}
}
