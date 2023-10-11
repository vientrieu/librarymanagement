package com.example.librarymanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity extends SuperEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "published_Date")
	private LocalDate publishedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private AuthorEntity author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

}
