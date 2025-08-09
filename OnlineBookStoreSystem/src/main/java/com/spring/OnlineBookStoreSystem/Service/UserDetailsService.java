package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.Model.UserDetails;
import com.spring.OnlineBookStoreSystem.Repository.UserDetailsRepository;

@Service
public class UserDetailsService {
	@Autowired
	private UserDetailsRepository userDRepo;
	
	public List<UserDetails> getAllUserDetails(){
		return userDRepo.findAll();
	}
	
	public Optional<UserDetails> getUserDetailsById(int id){
		return userDRepo.findById(id);
	}
	
	public String deleteUserDetails(int id) {
	    if(!userDRepo.existsById(id)) {
	        return "User Details not found";
	    }
	    userDRepo.deleteById(id);
	    return "User details deleted successfully";
	}

	
	public UserDetails saveUserDetails(UserDetails userD) {
		return userDRepo.save(userD);
	}
}
