package com.spring.OnlineBookStoreSystem.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.OnlineBookStoreSystem.DTO.CartDTO.CartRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CartDTO.CartResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/greet")
    public String greet() {
        return "Greet from Cart controller";
    }

    @GetMapping("/{id}")
    public Optional<CartResponseDTO> getCartById(@PathVariable int id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public CartResponseDTO addCart(@RequestBody CartRequestDTO cartRequest) {
        return cartService.addCart(cartRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteCartById(@PathVariable int id) {
        return cartService.deleteCartById(id);
    }

    @GetMapping("/userid/{userId}")
    public Optional<CartResponseDTO> findByCartByUserId(@PathVariable int userId) {
        return cartService.findByCartByUserId(userId);
    }

    @GetMapping("/username/{userName}")
    public Optional<CartResponseDTO> findByCartByUserName(@PathVariable String userName) {
        return cartService.findByCartByUserName(userName);
    }

    @DeleteMapping("/userid/{userId}")
    public String deleteCartByUserId(@PathVariable int userId) {
        return cartService.deleteCartByUserId(userId);
    }
}
