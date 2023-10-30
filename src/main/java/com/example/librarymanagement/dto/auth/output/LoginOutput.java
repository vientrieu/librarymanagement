package com.example.librarymanagement.dto.auth.output;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class LoginOutput implements Serializable {
	private static final long serialVersionUID = -6836438257033536332L;
	private Long userId;
	private String token;
}
