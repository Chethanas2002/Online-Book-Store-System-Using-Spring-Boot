package com.spring.OnlineBookStoreSystem.DTO.UserDTO;

import lombok.Data;

@Data
public class UserResponseDTO {
	private int userId;
	private String userName;
	private String password;
	private String role;
}
