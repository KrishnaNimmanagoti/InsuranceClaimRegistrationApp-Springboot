package com.insurance.dto;

import java.util.List;

import com.insurance.model.Claim;

import lombok.Data;

@Data
public class ClaimsResponseDTO {
	
	private String statusMessage;
	private List<Claim> claims;
	
}
