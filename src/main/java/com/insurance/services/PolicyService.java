package com.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.PolicyDTO;
import com.insurance.model.Policy;
import com.insurance.repositories.IPolicyRepository;

@Service
public class PolicyService {

	private static final String POLICY_CREATED_SUCCESSFULLY = "Policy created successfully.";

	@Autowired
	private IPolicyRepository policyRepo;

	public String createpolicy(PolicyDTO policyDTO) {
		Policy policy = new Policy(policyDTO);
		policyRepo.save(policy);
		return POLICY_CREATED_SUCCESSFULLY;
	}

	public List<Policy> getPolicies(String userName) {
		return policyRepo.findAllByUserName(userName);
	}

}
