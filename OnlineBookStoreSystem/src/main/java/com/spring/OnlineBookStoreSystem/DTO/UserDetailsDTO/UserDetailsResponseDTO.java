package com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO;

import lombok.Data;

@Data
public class UserDetailsResponseDTO {
	private int userDetailsId;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private long phoneNumber;
}
