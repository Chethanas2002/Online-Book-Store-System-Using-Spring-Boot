package com.spring.OnlineBookStoreSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public String deleteCartById(int id) {
		if(!cartRepo.existsById(id)) {
			return "Cart not found";
		}
		cartRepo.deleteById(id);
		return "Cart deleted successfully";
	}
	
	public Optional<Cart> getCartById(int id){
		return cartRepo.findById(id);
	}
	
	public Optional<Cart> findByCartByUserId(int userId){
		return cartRepo.findByUser_UserId(userId);
	}
	
	public Optional<Cart> findByCartByUserName(String userName){
		return cartRepo.findByUser_UserName(userName);
	}
	
//	@Transactional
//	public String deleteCartByUserId(int id) {
//		if(!cartRepo.existsByUser_UserId(id)) {
//			return "Cart not found with user id:" + id;
//		}
//		cartRepo.deleteByUser_UserId(id);
//		return "Cart deleted successfully with user id:" + id;
//	}
	
	@Transactional
	public String deleteCartByUserId(int userId) {
	    Optional<Cart> cartOpt = cartRepo.findByUser_UserId(userId);
	    Cart cart = cartOpt.get();
	    cart.setUser(null);
	    if (cartOpt.isPresent()) {
	        cartRepo.delete(cartOpt.get()); // delete managed entity
	        return "Cart deleted successfully with user id: " + userId;
	    } else {
	        return "No cart found for user id: " + userId;
	    }
	}

}
