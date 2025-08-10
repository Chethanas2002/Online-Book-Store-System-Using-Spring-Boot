package com.spring.OnlineBookStoreSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.OnlineBookStoreSystem.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	public Optional<Cart> findByUser_UserId(int userId);

	public Optional<Cart> findByUser_UserName(String userName);

//	@Query("delete c from cart c where c.user.userId= :id")
	public String deleteByUser_UserId(int userId);

	boolean existsByUser_UserId(int userId);

}