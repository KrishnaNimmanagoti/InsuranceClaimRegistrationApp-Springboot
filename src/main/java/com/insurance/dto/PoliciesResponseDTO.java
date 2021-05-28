package com.insurance.dto;

import java.util.List;

import com.insurance.model.Policy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PoliciesResponseDTO {

	private String statusMessage;
	private List<Policy> polices;

}
