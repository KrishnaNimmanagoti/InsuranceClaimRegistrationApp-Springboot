package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.insurance.dto.PolicyDetailsDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PolicyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Long policyNumber;
	private int questionID;
	private String answer;
	
	public PolicyDetails(PolicyDetailsDTO policyDetailsDTO) {
		this.policyNumber = policyDetailsDTO.getPolicyNumber();
		this.questionID = policyDetailsDTO.getQuestionID();
		this.answer = policyDetailsDTO.getAnswer();
	}

}
