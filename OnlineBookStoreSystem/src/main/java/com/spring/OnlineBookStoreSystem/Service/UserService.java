package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.User;
import com.spring.OnlineBookStoreSystem.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserByUserId(int id){
		return userRepo.findById(id);
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public String deleteUserById(int id) {
		
		Optional<User> user = userRepo.findById(id);
		if(user == null) {
			return "No User Found";
		}
		userRepo.deleteById(id);
		return "User deleted successfully";
	}

}
