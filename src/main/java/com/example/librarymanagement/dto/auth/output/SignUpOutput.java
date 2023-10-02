package com.example.librarymanagement.dto.auth.output;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class SignUpOutput {
	private Long userId;
	private String token;
}
