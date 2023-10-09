package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.account.input.ChangePasswordInput;
import com.example.librarymanagement.dto.account.input.UpdatePersonalInfoInput;
import com.example.librarymanagement.dto.account.output.GetPersonalInfoOutput;

/**
 * @author mangvientrieu
 */
public interface AccountService {
	GetPersonalInfoOutput getPersonalInfo();

	GetPersonalInfoOutput updatePersonalInfo(UpdatePersonalInfoInput input);

	Boolean changePassword(ChangePasswordInput input);
}
