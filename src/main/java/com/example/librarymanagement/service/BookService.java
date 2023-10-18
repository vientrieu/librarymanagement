package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.entity.BookEntity;
import com.example.librarymanagement.repository.projection.BorrowHistoryProjection;
import com.example.librarymanagement.repository.projection.CountBookProjection;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author mangvientrieu
 */
public interface BookService extends CRUDService<BookEntity> {
	Long borrowBook(BorrowBookInput input);

	boolean returnBook(ReturnBookInput input);

	Page<BorrowHistoryProjection> getBorrowHistory(int page, int size);

	List<BookEntity> searchBookByKeyword(String keyword);

	List<BookEntity> importBookFromExcel(MultipartFile file);

	List<CountBookProjection> countTotalBook();

	List<CountBookProjection> countExistedBook();
}
