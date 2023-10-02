package com.example.librarymanagement.entity;

import com.example.librarymanagement.customenum.RoleEnum;
import com.example.librarymanagement.customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
@Entity
@Table(name = "library_user")
public class UserEntity extends SuperEntity {

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private UserTypeEnum type;

	@Column(name = "birthday")
	private LocalDate birthday;

	@Column(name = "card_id_number", unique = true)
	private String cardIdNumber;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleEnum role;
}
