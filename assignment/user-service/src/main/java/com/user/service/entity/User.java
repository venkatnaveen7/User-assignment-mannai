package com.user.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false,nullable = false)
	Long id;

	String fullName;

	@Column(nullable = false,unique = true)
	String email;

	String mobileNumber;




}
