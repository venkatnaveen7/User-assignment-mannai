package com.user.service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class OTP {


	private String otp;

	private boolean isOtpUsed;

	@Id
	private  String email;

	private  String mobileNumber;

	private Date timestamp = new Date();
}
