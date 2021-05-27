package com.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.ClaimDTO;
import com.insurance.model.Claim;
import com.insurance.repositories.IClaimRepository;

@Service
public class ClaimService {
	
	@Autowired
	private IClaimRepository claimRepo;
	
	public String createClaim(ClaimDTO claimDTO) {
		Claim claim = new Claim(claimDTO);
		claimRepo.save(claim);
		return "Claim created Successfully";
	}

	public List<Claim> getClaimList() {
		return claimRepo.findAll();
	}

}
