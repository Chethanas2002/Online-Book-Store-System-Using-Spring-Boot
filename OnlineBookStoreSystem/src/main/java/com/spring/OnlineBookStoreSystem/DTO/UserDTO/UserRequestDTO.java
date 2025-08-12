package com.spring.OnlineBookStoreSystem.DTO.UserDTO;

import lombok.Data;

@Data
public class UserRequestDTO {
	private String userName;
	private String password;
	private String role;
}
