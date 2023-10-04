package com.example.librarymanagement.dto.auth;

import com.example.librarymanagement.customenum.RoleEnum;
import com.example.librarymanagement.customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class UserAuthentication {
	private Long userId;
	private RoleEnum role;
	private UserTypeEnum type;
}
