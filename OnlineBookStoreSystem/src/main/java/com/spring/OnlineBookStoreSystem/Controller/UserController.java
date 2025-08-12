package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.UserDTO.UserRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.UserDTO.UserResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO userDto) {
        return ResponseEntity.ok(userService.saveUser(userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDTO>> getUserByUserId(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserByUserId(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    // Linking End points
    @PutMapping("/{userId}/cart/{cartId}")
    public ResponseEntity<String> linkUserWithCart(@PathVariable int userId, @PathVariable int cartId) {
        return ResponseEntity.ok(userService.linkUserWithCart(userId, cartId));
    }

    @PutMapping("/{userId}/details/{detailsId}")
    public ResponseEntity<String> linkUserWithUserDetails(@PathVariable int userId, @PathVariable int detailsId) {
        return ResponseEntity.ok(userService.linkUserWithUserDetails(userId, detailsId));
    }

    @PutMapping("/{userId}/order/{orderId}")
    public ResponseEntity<String> linkUserWithOrder(@PathVariable int userId, @PathVariable int orderId) {
        return ResponseEntity.ok(userService.linkUserWithOrder(userId, orderId));
    }
}
