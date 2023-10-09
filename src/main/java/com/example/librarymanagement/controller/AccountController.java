package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.account.input.ChangePasswordInput;
import com.example.librarymanagement.dto.account.input.UpdatePersonalInfoInput;
import com.example.librarymanagement.dto.account.output.GetPersonalInfoOutput;
import com.example.librarymanagement.dto.api.ResponseDto;
import com.example.librarymanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mangvientrieu
 * Controller dùng để truy cập và điều chỉnh các thông tin liên quan đến cá nhân
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/personal-info")
	public ResponseDto<GetPersonalInfoOutput> getPersonalInfo() {
		return ResponseDto.ok(accountService.getPersonalInfo());
	}

	@PutMapping("/personal-info")
	public ResponseDto<GetPersonalInfoOutput> updatePersonalInfo(@RequestBody UpdatePersonalInfoInput input) {
		return ResponseDto.ok(accountService.updatePersonalInfo(input));
	}

	@PostMapping("/change-password")
	public ResponseDto<Boolean> changePassword(@RequestBody ChangePasswordInput input) {
		return ResponseDto.ok(accountService.changePassword(input));
	}

}
