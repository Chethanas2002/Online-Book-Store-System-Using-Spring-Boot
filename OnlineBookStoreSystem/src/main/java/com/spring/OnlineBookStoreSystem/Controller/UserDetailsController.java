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

import com.spring.OnlineBookStoreSystem.Model.UserDetails;
import com.spring.OnlineBookStoreSystem.Service.UserDetailsService;

@RestController
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDService;
	
	@GetMapping("/ud")
	public String greet() {
		return "User Details greet";
	}
	
	@PostMapping("/userdetails")
	public UserDetails save(@RequestBody UserDetails user) {
		return userDService.saveUserDetails(user);
	}
	
	@GetMapping("/userdetails/{id}")
	public Optional<UserDetails> getUserDetailsById(@PathVariable int id) {
		return userDService.getUserDetailsById(id);
	}
	
	@GetMapping("/userdetails")
	public List<UserDetails> getAll(){
		return userDService.getAllUserDetails();
	}
	
	@DeleteMapping("/userdetails/{id}")
	public String deleteUserDetails(@PathVariable int id) {
		return userDService.deleteUserDetails(id);
	}
}
