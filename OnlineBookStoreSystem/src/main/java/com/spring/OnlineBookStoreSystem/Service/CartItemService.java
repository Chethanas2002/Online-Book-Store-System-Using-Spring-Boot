package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.CartItem;
import com.spring.OnlineBookStoreSystem.Repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository cItemRepo;
	
	public Optional<CartItem> getCartItemById(int cartItemId){
		return cItemRepo.findById(cartItemId);
	}
	
	public List<CartItem> getAllCartItem(){
		return cItemRepo.findAll();
	}
	
	public CartItem addCartItem(CartItem cartItem) {
		return cItemRepo.save(cartItem);
	}
	
	public String deleteCartItemById(int cartItemId) {
		if(!cItemRepo.existsById(cartItemId)) {
			return "Cart Item not found";
		}
		cItemRepo.deleteById(cartItemId);
		return "Cart item deleted successfully";
	}
}
