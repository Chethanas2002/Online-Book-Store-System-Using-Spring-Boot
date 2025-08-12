package com.spring.OnlineBookStoreSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	List<CartItem> findByCart_User_UserId(int userId);
}
