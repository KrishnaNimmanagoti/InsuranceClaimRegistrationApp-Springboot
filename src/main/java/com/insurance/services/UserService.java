package com.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.PolicyDTO;
import com.insurance.dto.UserDTO;
import com.insurance.model.Policy;
import com.insurance.model.UserRole;
import com.insurance.repositories.IPolicyRepository;
import com.insurance.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IPolicyRepository policyRepo;

	public String createUserAccount(UserDTO userDTO) {
		if (policyRepo.existsByUserName(userDTO.getUserName())) {
			if (!userRepo.existsByUserName(userDTO.getUserName())) {
				UserRole user = new UserRole(userDTO);
				userRepo.save(user);
				return "User Account created successfully";
			} else
				return "UserID Already Exists";
		} else {
			return "Profile creation failed as no policy(s) found for the user: " + userDTO.getUserName();
		}
	}

	public boolean loginValidation(UserDTO userDTO) {
		if (userRepo.existsByUserName(userDTO.getUserName())) {
			if (userRepo.findByUserName(userDTO.getUserName()).getPassword().equals(userDTO.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
