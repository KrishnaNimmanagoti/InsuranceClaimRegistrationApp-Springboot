package com.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.UserRole;

@Repository
public interface IUserRepository extends JpaRepository<UserRole, Integer> {

	boolean existsByUserName(String userName);
	
	UserRole findByUserName(String userName);
	
}