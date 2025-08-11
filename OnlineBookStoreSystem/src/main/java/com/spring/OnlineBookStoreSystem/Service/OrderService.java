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
	
	
	public List<Orders> findByStatus(String status){
		return orderRepo.findByStatusIgnoreCase(status);
	}
	
	public List<Orders> findByUser_UserId(int id){
		return orderRepo.findByUser_UserId(id);
	}
	
	public List<Orders> findByUser_UserName(String name){
		return orderRepo.findByUser_UserNameIgnoreCase(name);
	}
	
	public List<Orders> findByUser_UserIdOrderByOrderDateDesc(int userId){
		return orderRepo.findByUser_UserIdOrderByOrderDateDesc(userId);
	}
}
