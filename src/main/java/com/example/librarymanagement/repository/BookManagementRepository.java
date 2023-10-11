package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.BookManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookManagementRepository extends JpaRepository<BookManagementEntity, Long> {

	@Query(value = "select * " +
			"from book_management o " +
			"where o.user_id = :userId and o.book_distribution_id = :bookDistributionId and o.return_date is null",
			nativeQuery = true)
	List<BookManagementEntity> findBorrowInformation(Long userId, Long bookDistributionId);

	@Query(value = "select * " +
			"from book_management o " +
			"where o.user_id = :userId",
			nativeQuery = true)
	List<BookManagementEntity> findBorrowHistory(Long userId);
}