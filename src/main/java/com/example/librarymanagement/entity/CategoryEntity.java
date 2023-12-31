package com.example.librarymanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity extends SuperEntity {

	@Column(name = "name")
	private String name;

}
