package com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO;

import lombok.Data;

@Data
public class UserDetailsRequestDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private long phoneNumber;
}
