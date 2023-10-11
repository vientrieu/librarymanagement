package com.example.librarymanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
@Entity
@Table(name = "book_distribution", indexes = {
		@Index(name = "idx_book_id_and_status", columnList = "book_id, status")
})
public class BookDistributionEntity extends SuperEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private BookEntity book;

	@Column(name = "status")
	private String status;

	@OneToMany(mappedBy = "bookDistribution", fetch = FetchType.LAZY)
	private List<BookManagementEntity> histories;
}
