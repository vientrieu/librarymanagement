package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findFirstByUsername(String username);

	UserEntity findFirstByCardIdNumber(String cardIdNumber);

	UserEntity findFirstByPhoneNumber(String phoneNumber);
}