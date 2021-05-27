package com.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.insurance.dto.UserDTO;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String loginid;
	private String password;
	private String roleType;
	
	public UserRole(UserDTO userDTO) {
		this.loginid = userDTO.getLoginid();
		this.password = userDTO.getPassword();
		this.roleType = userDTO.getRoleType();
	}
}
