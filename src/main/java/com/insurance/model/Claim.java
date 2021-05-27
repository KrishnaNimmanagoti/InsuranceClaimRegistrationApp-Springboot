package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insurance.dto.ClaimDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Long claimNumber;
	private String claimReason;
	private String accidentLocationStreet;
	private String accidentCity;
	private String accidentState;
	private String accidentZip;
	private String claimType;
	private Long policyNumber;
	
	public Claim(ClaimDTO claimDTO) {
		this.claimNumber = claimDTO.getClaimNumber();
		this.claimReason = claimDTO.getClaimReason();
		this.accidentLocationStreet = claimDTO.getAccidentLocationStreet();
		this.accidentCity = claimDTO.getAccidentCity();
		this.accidentState = claimDTO.getAccidentState();
		this.accidentZip = claimDTO.getAccidentZip();
		this.claimType = claimDTO.getClaimType();
		this.policyNumber = claimDTO.getPolicyNumber();
	}
	
	
}
