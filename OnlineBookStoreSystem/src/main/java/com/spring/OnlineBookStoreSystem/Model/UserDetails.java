package com.spring.OnlineBookStoreSystem.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userDetailsId;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String address;
	private long phoneNumber;
	
	@JsonBackReference
	@OneToOne(mappedBy = "userDetails",cascade = CascadeType.ALL)
	private User user;
}
