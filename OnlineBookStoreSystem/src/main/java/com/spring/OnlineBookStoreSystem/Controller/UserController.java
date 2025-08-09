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

import com.spring.OnlineBookStoreSystem.Model.User;
import com.spring.OnlineBookStoreSystem.Service.UserService;

@RestController("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String greet() {
		return "Greet from User Controller";
	}
	
	@PostMapping("users")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("users/{id}")
	public Optional<User> getUserByUserId(@PathVariable("id") int userId){
		return userService.getUserByUserId(userId);
	}
	
	@GetMapping("users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@DeleteMapping("users/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		return userService.deleteUserById(userId);
	}
	
}
