package com.insurance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PolicyDTO {
	
	@Size(min = 3, max=20)
	@NotEmpty(message = "User Name should be not empty")
	private String userName;
	
	@NotNull(message = "Policy Number should be not empty")
	private Long policyNumber;
	
	@NotNull(message = "Account Number should be not empty")
	private Long accountNumber;
	
	@NotNull(message = "Premium Amount should be not empty")
	private Double premiumAmount;
	
}
