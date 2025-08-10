package com.spring.OnlineBookStoreSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Repository.CartRepository;

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
}
