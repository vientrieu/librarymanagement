package com.example.librarymanagement.dto.auth.output;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class LoginOutput {
	private Long userId;
	private String token;
}
