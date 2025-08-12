package com.spring.OnlineBookStoreSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO.UserDetailsRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO.UserDetailsResponseDTO;
import com.spring.OnlineBookStoreSystem.Service.UserDetailsService;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDService;

    // Create UserDetails
    @PostMapping
    public ResponseEntity<UserDetailsResponseDTO> save(@RequestBody UserDetailsRequestDTO requestDTO) {
        UserDetailsResponseDTO savedDetails = userDService.saveUserDetails(requestDTO);
        return ResponseEntity.ok(savedDetails);
    }

    // Get UserDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsResponseDTO> getUserDetailsById(@PathVariable int id) {
        return userDService.getUserDetailsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all UserDetails
    @GetMapping
    public ResponseEntity<List<UserDetailsResponseDTO>> getAll() {
        return ResponseEntity.ok(userDService.getAllUserDetails());
    }

    // Delete UserDetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable int id) {
        String result = userDService.deleteUserDetails(id);
        return ResponseEntity.ok(result);
    }
}
