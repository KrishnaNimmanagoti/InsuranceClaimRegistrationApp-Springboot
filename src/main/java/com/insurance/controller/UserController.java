package com.insurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.UserDTO;
import com.insurance.services.UserService;

@RestController
@RequestMapping("/claimregistraion")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createprofile")
	public ResponseEntity<String> createProfile(@Valid @RequestBody UserDTO userDTO) {
		String user = userService.createUserAccount(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/userlogin")
	public ResponseEntity<String> userLogin(@RequestBody UserDTO userDTO) {
		String user = userService.userLogin(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

}
