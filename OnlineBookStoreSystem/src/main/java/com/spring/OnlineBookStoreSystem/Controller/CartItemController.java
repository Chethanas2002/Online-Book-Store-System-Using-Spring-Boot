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

import com.spring.OnlineBookStoreSystem.Model.CartItem;
import com.spring.OnlineBookStoreSystem.Service.CartItemService;

@RestController
public class CartItemController {
	
	@Autowired
	private CartItemService cItemService;
	
	@GetMapping("/ci")
	public String greet() {
		return "Greet from cart item";
	}
	
	@GetMapping("/cartitem/{cartItemId}")
	public Optional<CartItem> getCartItemById(@PathVariable int cartItemId){
		return cItemService.getCartItemById(cartItemId);
	}
	
	@GetMapping("/cartitem")
	public List<CartItem> getAllCartItem(){
		return cItemService.getAllCartItem();
	}
	
	@PostMapping("/cartitem")
	public CartItem addCartItem(@RequestBody CartItem cartItem) {
		return cItemService.addCartItem(cartItem);
	}
	
	@DeleteMapping("/cartitem/{cartItemId}")
	public String deleteCartItemById(@PathVariable int cartItemId) {
		
		return cItemService.deleteCartItemById(cartItemId);
		 
	}
	
}
