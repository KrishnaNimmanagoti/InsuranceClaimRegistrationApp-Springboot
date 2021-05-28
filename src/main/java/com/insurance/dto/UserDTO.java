package com.insurance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserDTO {
	
	@NotEmpty(message = "User Name should be not empty")
	private String userName;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=[^$@!#%*?&]*[$#@!%*?&][^$@!#%*?&]*$).{8,}", message = "Password is incorrect")
	@NotEmpty(message = "Please enter password")
	private String password;
	
	@NotEmpty(message = "Please enter role type")
	private String roleType;

}

