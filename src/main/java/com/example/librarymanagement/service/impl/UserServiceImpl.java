package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.entity.UserEntity;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mangvientrieu
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity create(UserEntity input) {
		return userRepository.save(input);
	}

	@Override
	public List<UserEntity> read() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity update(UserEntity newValue) {
		return userRepository.save(newValue);
	}

	@Override
	public boolean delete(Long id) {
		userRepository.deleteById(id);
		return true;
	}
}
