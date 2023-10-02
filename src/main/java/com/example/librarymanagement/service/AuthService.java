package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.auth.input.SignUpInput;
import com.example.librarymanagement.dto.auth.output.SignUpOutput;

/**
 * @author mangvientrieu
 */
public interface AuthService {
	SignUpOutput signUp(SignUpInput input);
}
