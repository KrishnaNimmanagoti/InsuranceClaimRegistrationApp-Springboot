package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insurance.dto.PolicyDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	private Long policyNumber;
	private Long accountNumber;
	private Double premiumAmount;
	
	public Policy(PolicyDTO policyDTO) {
		this.userName = policyDTO.getUserName();
		this.policyNumber = policyDTO.getPolicyNumber();
		this.accountNumber = policyDTO.getAccountNumber();
		this.premiumAmount = policyDTO.getPremiumAmount();
	}
}
