package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.auth.input.LoginInput;
import com.example.librarymanagement.dto.auth.input.SignUpInput;
import com.example.librarymanagement.dto.auth.output.LoginOutput;
import com.example.librarymanagement.dto.auth.output.SignUpOutput;

/**
 * @author mangvientrieu
 */
public interface AuthService {
	LoginOutput login(LoginInput input);
	SignUpOutput signUp(SignUpInput input);
}
