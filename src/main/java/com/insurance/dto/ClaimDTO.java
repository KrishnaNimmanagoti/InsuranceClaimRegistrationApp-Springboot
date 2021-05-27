package com.insurance.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ClaimDTO {
	
	@NotEmpty(message = "Claim Number should be not empty")
	private Long claimNumber;
	
	@NotEmpty(message = "Claim Reason should be not empty")
	private String claimReason;
	
	@NotEmpty(message = "Accident Location Street should be not empty")
	private String accidentLocationStreet;
	
	@NotEmpty(message = "Accident City should be not empty")
	private String accidentCity;
	
	@NotEmpty(message = "Accident State should be not empty")
	private String accidentState;
	
	@NotEmpty(message = "Accident Zip should be not empty")
	private String accidentZip;
	
	@NotEmpty(message = "Claim Type should be not empty")
	private String claimType;
	
	@NotEmpty(message = "Policy Number should be not empty")
	private Long policyNumber;

}
