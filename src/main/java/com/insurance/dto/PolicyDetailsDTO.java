package com.insurance.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PolicyDetailsDTO {
	
	@NotEmpty(message = "Policy Number should be not empty")
	private Long policyNumber;
	
	@NotEmpty(message = "Question ID should be not empty")
	private int questionID;
	
	@NotEmpty(message = "Answer should be not empty")
	private String answer;

}
