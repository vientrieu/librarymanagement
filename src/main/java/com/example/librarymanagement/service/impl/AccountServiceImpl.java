package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.account.output.GetPersonalInfoOutput;
import com.example.librarymanagement.dto.auth.UserAuthentication;
import com.example.librarymanagement.entity.UserEntity;
import com.example.librarymanagement.exception.BusinessException;
import com.example.librarymanagement.mapper.UserMapper;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author mangvientrieu
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public GetPersonalInfoOutput getPersonalInfo() {
		UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserEntity userFound = userRepository.findById(userAuthentication.getUserId())
				.orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));
		return UserMapper.INSTANCE.mapToPersonalInfoOutput(userFound);
	}
}
