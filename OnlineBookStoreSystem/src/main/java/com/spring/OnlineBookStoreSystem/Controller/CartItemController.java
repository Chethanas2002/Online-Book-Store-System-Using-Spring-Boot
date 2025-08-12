package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.CartItemDTO.CartItemRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.CartItemDTO.CartItemResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.CartItemService;

@RestController
@RequestMapping("/cartitem")
public class CartItemController {

    @Autowired
    private CartItemService cItemService;

    @GetMapping("/greet")
    public String greet() {
        return "Greet from cart item";
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<Optional<CartItemResponseDTO>> getCartItemById(@PathVariable int cartItemId) {
        return ResponseEntity.ok(cItemService.getCartItemById(cartItemId));
    }

    @GetMapping
    public ResponseEntity<List<CartItemResponseDTO>> getAllCartItem() {
        return ResponseEntity.ok(cItemService.getAllCartItem());
    }

    @PostMapping
    public ResponseEntity<CartItemResponseDTO> addCartItem(@RequestBody CartItemRequestDTO dto) {
        return ResponseEntity.ok(cItemService.addCartItem(dto));
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<String> deleteCartItemById(@PathVariable int cartItemId) {
        return ResponseEntity.ok(cItemService.deleteCartItemById(cartItemId));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CartItemResponseDTO>> getCartItemsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(cItemService.getCartItemsByUserId(userId));
    }
}
