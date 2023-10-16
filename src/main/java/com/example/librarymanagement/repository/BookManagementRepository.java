package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.BookManagementEntity;
import com.example.librarymanagement.repository.projection.BorrowHistoryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query(value = "select bm.id as id, " +
			"bm.create_date as createDate, " +
			"bm.borrow_date as borrowDate, " +
			"bm.return_date as returnDate, " +
			"bm.book_distribution_id as bookDistributionId, " +
			"b.name as bookName " +
			"from book_management bm " +
			"left join book_distribution bd " +
			"on bm.book_distribution_id = bd.id " +
			"left join book b " +
			"on bd.book_id = b.id " +
			"where bm.user_id = :userId",
			nativeQuery = true)
	Page<BorrowHistoryProjection> findBorrowHistory(Long userId, Pageable pageable);

}