package com.example.librarymanagement.repository.projection;

import com.example.librarymanagement.entity.BookManagementEntity;

import java.time.LocalDate;

/**
 * Projection for {@link BookManagementEntity}
 */
public interface BorrowHistoryProjection {
	Long getId();

	Long getBookDistributionId();

	LocalDate getCreateDate();

	LocalDate getBorrowDate();

	LocalDate getReturnDate();

	String getBookName();
}