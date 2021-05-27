package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Policy;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Integer>{

}
