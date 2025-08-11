package com.spring.OnlineBookStoreSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
//	find order by status
	public List<Orders> findByStatusIgnoreCase(String status);
	
//	find order by order date
//	public List<Order> findByOrderDate(String name);
//	public List<Orders> findByOrderDate(LocalDate orderDate);

	
//	find order by user id
	public List<Orders> findByUser_UserId(int userId);
	
//	find order by user name
	public List<Orders> findByUser_UserNameIgnoreCase(String userName);
	
//	get all order for a user
	
	public List<Orders> findByUser_UserIdOrderByOrderDateDesc(int userId);
}
