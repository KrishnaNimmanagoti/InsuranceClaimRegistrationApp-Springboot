package com.insurance.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.dto.PoliciesResponseDTO;
import com.insurance.dto.UserDTO;
import com.insurance.model.Policy;
import com.insurance.services.PolicyService;
import com.insurance.services.UserService;

@RestController
@RequestMapping("/claimregistraion")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PolicyService policyService;

	@PostMapping("/createprofile")
	public ResponseEntity<String> createProfile(@Valid @RequestBody UserDTO userDTO) {
		String user = userService.createUserAccount(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PostMapping("/userlogin")
	public ResponseEntity<PoliciesResponseDTO> userLogin(@RequestBody UserDTO userDTO) {
		PoliciesResponseDTO dto = new PoliciesResponseDTO();
		if (userService.loginValidation(userDTO)) {
			List<Policy> polices = policyService.getPolicies(userDTO.getUserName());
			dto.setStatusMessage("Login Successful.");
			dto.setPolices(polices);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			dto.setStatusMessage("No profile found with the user id: " + userDTO.getUserName());
			return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
		}
	}
}
