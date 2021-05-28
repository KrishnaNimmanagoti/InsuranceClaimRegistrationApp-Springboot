package com.insurance.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.dto.PolicyDTO;
import com.insurance.services.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/createpolicy")
	public ResponseEntity<String> addPolicies(@Valid @RequestBody PolicyDTO policyDTO) {
		String response = policyService.createpolicy(policyDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
