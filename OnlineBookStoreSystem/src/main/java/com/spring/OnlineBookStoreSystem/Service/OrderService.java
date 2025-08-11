package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Orders;
import com.spring.OnlineBookStoreSystem.Repository.OrderRepository;

@Service

public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	public List<Orders> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public Optional<Orders> getOrderById(int id){
		return orderRepo.findById(id);
	}
	
	public Orders addOrders(Orders order) {
		return orderRepo.save(order);
	}
	
	public String deleteOrderById(int id) {
		if(!orderRepo.existsById(id)) {
			return "Order not found";
		}
		orderRepo.deleteById(id);
		return "Order deleted successfully";
	}
}
