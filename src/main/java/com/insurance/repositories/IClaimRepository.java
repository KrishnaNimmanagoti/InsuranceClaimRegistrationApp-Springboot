package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Claim;

@Repository
public interface IClaimRepository extends JpaRepository<Claim, Integer>{

	boolean existsByPolicyNumber(Long policyNumber);

	Claim getByPolicyNumber(Long policyNumber);

}
