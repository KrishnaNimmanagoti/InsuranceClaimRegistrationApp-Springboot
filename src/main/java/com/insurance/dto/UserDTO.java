package com.insurance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {
	
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email should be not empty")
	private String loginid;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^$@!#%*?&]*[$#@!%*?&][^$@!#%*?&]*$).{8,}", message = "Password is incorrect")
	@NotEmpty(message = "Please enter password")
	private String password;
	
	@NotEmpty(message = "Please enter role type")
	private String roleType;

}

