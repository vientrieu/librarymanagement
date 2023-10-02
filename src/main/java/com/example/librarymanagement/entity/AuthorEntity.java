package com.example.librarymanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "author")
public class AuthorEntity extends SuperEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "birthday")
	private LocalDate birthday;

}
