package com.spring.OnlineBookStoreSystem.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.Model.Cart;
import com.spring.OnlineBookStoreSystem.Service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/ct")
	public String greet() {
		return "Greet from Cart controller";
	}
	
	@GetMapping("/cart/{id}")
	public Optional<Cart> getCartById(@PathVariable int id) {
		return cartService.getCartById(id);
	}
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}
	
	@DeleteMapping("/cart/{id}")
	public String deleteCartById(@PathVariable int id) {
		return cartService.deleteCartById(id);
	}
	
	@GetMapping("/cart/userid/{userId}")
	public Optional<Cart> findByCartByUserId(@PathVariable int userId){
		return cartService.findByCartByUserId(userId);
	}
	
	@GetMapping("/cart/username/{userName}")
	public Optional<Cart> findByCartByUserName(@PathVariable String userName){
		return cartService.findByCartByUserName(userName);
	}
	
	
	@DeleteMapping("/cart/userid/{userId}")
	public String deleteCartByUserId(@PathVariable int userId) {
		return cartService.deleteCartByUserId(userId);
	}
}
