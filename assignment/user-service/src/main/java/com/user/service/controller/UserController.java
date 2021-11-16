package com.user.service.controller;

import com.user.service.dto.UserDTO;
import com.user.service.serv.EmailService;
import com.user.service.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	EmailService emailService;

	@PostMapping("/saveUser")
	public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
		emailService.sendMail(userDTO.getEmail());
		return  new ResponseEntity("OTP Has been sent", HttpStatus.OK);
	}

	/*@PostMapping("/completeUserSave")
	public ResponseEntity completeUserSave(@RequestBody UserDTO userDTO) {
		userDTO.setPartialSave(false);
		userService.saveUser(userDTO);
		return  new ResponseEntity("User Saved", HttpStatus.OK);
	}*/

	@PostMapping("/validateOTP")
	public ResponseEntity validateOTP(@RequestBody UserDTO userDTO, @RequestParam String otp) {
		return  new ResponseEntity(emailService.validateOTP(userDTO.getEmail(),otp), HttpStatus.OK);
	}
}
