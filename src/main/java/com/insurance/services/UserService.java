package com.insurance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.UserDTO;
import com.insurance.model.UserRole;
import com.insurance.repositories.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepo;

	public String createUserAccount(UserDTO userDTO) {
		if (!userRepo.existsByLoginid(userDTO.getLoginid())) {
			UserRole user = new UserRole(userDTO);
			userRepo.save(user);
			return "User Account created successfully";
		} else
			return "UserID Already Exists";
	}

	public String userLogin(UserDTO userDTO) {
		UserRole userRole = userRepo.findByLoginid(userDTO.getLoginid());
		if (userRole.getPassword().equals(userDTO.getPassword()))
			return "Login Successful";
		else 
			return "Login Failed"; 
	}
	
}
