package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.PolicyDetails;

@Repository
public interface IPolicyDetailsRepository extends JpaRepository<PolicyDetails, Integer>{

}
