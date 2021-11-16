package com.user.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class ServiceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	String requestType;

	String requestDetails;

	String status;

	Date lastUpdated= new Date();


}
