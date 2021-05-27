package com.insurance.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PolicyDTO {
	
	@NotEmpty(message = "User Name should be not empty")
	private String userName;
	
	@NotEmpty(message = "Policy Number should be not empty")
	private Long policyNumber;
	
	@NotEmpty(message = "Account Number should be not empty")
	private Long accountNumber;
	
	@NotEmpty(message = "Premium Amount should be not empty")
	private Double premiumAmount;

}
