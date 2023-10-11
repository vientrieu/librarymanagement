package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.BookDistributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDistributionRepository extends JpaRepository<BookDistributionEntity, Long> {
	List<BookDistributionEntity> findByBookIdAndStatus(Long bookId, String status);

	Optional<BookDistributionEntity> findFirstByBookIdAndStatus(Long bookId, String status);

}