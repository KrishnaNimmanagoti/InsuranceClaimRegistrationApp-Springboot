package com.insurance.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.ClaimDTO;
import com.insurance.dto.ClaimsResponseDTO;
import com.insurance.model.Claim;
import com.insurance.model.Policy;
import com.insurance.repositories.IClaimRepository;
import com.insurance.repositories.IPolicyRepository;

@Service
public class ClaimService {
	
	private static final String NO_CLAIMS_FOUND_FOR_THE_USER_ID = "No claims found for the user id: ";
	private static final String CLAIMS_SUCCESSFULLY_RETRIEVED = "Claims successfully retrieved.";
	private static final String NO_POLICY_FOUND = "Claim creation failed - No policy found with policy number: ";
	private static final String CLAIM_CREATION_FAILED = "Claim creation failed - already claim exist with policy number: ";
	private static final String CLAIM_CREATION_IS_SUCCESSFULL = "Claim creation is Successfull.";
	
	@Autowired
	private IClaimRepository claimRepo;
	
	@Autowired
	private IPolicyRepository policyRepo;
	
	public String createClaim(ClaimDTO claimDTO) {
		if(policyRepo.existsByPolicyNumber(claimDTO.getPolicyNumber())) {
			if(!claimRepo.existsByPolicyNumber(claimDTO.getPolicyNumber())) {
				Claim claim = new Claim(claimDTO);
				claimRepo.save(claim);
				return CLAIM_CREATION_IS_SUCCESSFULL;
			} else {
				return CLAIM_CREATION_FAILED + claimDTO.getPolicyNumber();
			}
		} else {
			return NO_POLICY_FOUND + claimDTO.getPolicyNumber();
		}
	}

	public ClaimsResponseDTO getUserClaims(String userName) {
		ClaimsResponseDTO dto = new ClaimsResponseDTO();
		if(policyRepo.existsByUserName(userName)) {
			List<Policy> policies = policyRepo.findAllByUserName(userName);
			
			System.out.println("policies size: " + policies.size());
			
			List<Claim> claims = new ArrayList<>();
			for(Policy policy : policies) {
				Claim claim = claimRepo.getByPolicyNumber(policy.getPolicyNumber());
				
				if(null != claim && claim.getPolicyNumber() != null) {
					claims.add(claim);
				}
			}
			
			dto.setClaims(claims);
			dto.setStatusMessage(CLAIMS_SUCCESSFULLY_RETRIEVED);
			
			return dto;
		} else {
			dto.setStatusMessage(NO_CLAIMS_FOUND_FOR_THE_USER_ID + userName);
			return dto;
		}
		
	}

}
