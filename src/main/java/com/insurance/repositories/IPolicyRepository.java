package com.insurance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Policy;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer>{
	
	boolean existsByUserName(String userName);

	List<Policy> findAllByUserName(String userName);

	boolean existsByPolicyNumber(Long policyNumber);

}
