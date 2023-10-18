package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.BookDistributionEntity;
import com.example.librarymanagement.repository.projection.CountBookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDistributionRepository extends JpaRepository<BookDistributionEntity, Long> {
	List<BookDistributionEntity> findByBookIdAndStatus(Long bookId, String status);

	Optional<BookDistributionEntity> findFirstByBookIdAndStatus(Long bookId, String status);

	@Query(nativeQuery = true, value = "select b.id as bookId, count(bd.id) as number " +
			"from book b " +
			"left join book_distribution bd " +
			"on b.id = bd.book_id " +
			"group by b.id")
	List<CountBookProjection> countTotalBook();

	@Query(nativeQuery = true, value = "select b.id as bookId, count(bd.id) as number " +
			"from book b " +
			"left join book_distribution bd " +
			"on b.id = bd.book_id " +
			"where bd.status = 'ENABLE' " +
			"group by b.id")
	List<CountBookProjection> countExistedBook();

}