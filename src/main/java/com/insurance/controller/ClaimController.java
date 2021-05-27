package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.ClaimDTO;
import com.insurance.model.Claim;
import com.insurance.services.ClaimService;

@RestController
@RequestMapping("/claimregistraion")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@PostMapping("/createclaim")
	public ResponseEntity<String> createClaim(@RequestBody ClaimDTO claimDTO) {
		return new ResponseEntity<>(claimService.createClaim(claimDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/getclaimlist")
	public ResponseEntity<List<Claim>> getClaimList() {
		return new ResponseEntity<>(claimService.getClaimList(), HttpStatus.CREATED);
	}
	
}
