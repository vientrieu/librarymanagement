package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.customenum.RoleEnum;
import com.example.librarymanagement.customenum.UserTypeEnum;
import com.example.librarymanagement.dto.auth.input.SignUpInput;
import com.example.librarymanagement.dto.auth.output.SignUpOutput;
import com.example.librarymanagement.entity.UserEntity;
import com.example.librarymanagement.exception.BusinessException;
import com.example.librarymanagement.mapper.UserMapper;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mangvientrieu
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public SignUpOutput signUp(SignUpInput input) {
		// Kiểm tra username có tồn tại chưa
		String username = input.getUsername();
		UserEntity existedUsername = userRepository.findFirstByUsername(username);
		if (existedUsername != null) {
			throw new BusinessException("EXISTED_USERNAME", "Tài khoản đã tồn tại!");
		}
		String cardIdNumber = input.getCardIdNumber();
		UserEntity existedCardIdNumber = userRepository.findFirstByCardIdNumber(cardIdNumber);
		if (existedCardIdNumber != null) {
			throw new BusinessException("EXISTED_CARD_ID_NUMBER", "Giấy tờ tùy thân đã tồn tại!");
		}
		String phoneNumber = input.getPhoneNumber();
		UserEntity existedPhoneNumber = userRepository.findFirstByPhoneNumber(phoneNumber);
		if (existedPhoneNumber != null) {
			throw new BusinessException("EXISTED_PHONE_NUMBER", "Số điện thoại đã tồn tại!");
		}
		UserEntity newUser = UserMapper.INSTANCE.mapFromSignUpInput(input);
		newUser.setRole(RoleEnum.USER);
		newUser.setType(UserTypeEnum.BASIC);
		userRepository.save(newUser);

		SignUpOutput output = new SignUpOutput();
		output.setUserId(newUser.getId());
		return output;
	}
}
