package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName; 
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	private String mobile;
	
	private String address;

//	public User(UserDto dto) {
//		super();
//		this.firstName = dto.getFirstName();
//		this.lastName = dto.getLastName();
//		this.email = dto.getEmail();
//		this.password = dto.getPassword();
//		this.role = RoleEnum.valueOf(dto.getRole());
//		this.mobile = dto.getMobile();
//		this.address = dto.getAddress();
//	}
	
	
	
}
