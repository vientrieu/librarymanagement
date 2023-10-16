package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.entity.BookEntity;
import com.example.librarymanagement.repository.projection.BorrowHistoryProjection;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author mangvientrieu
 */
public interface BookService {
	Long borrowBook(BorrowBookInput input);

	boolean returnBook(ReturnBookInput input);

	Page<BorrowHistoryProjection> getBorrowHistory(int page, int size);

	List<BookEntity> searchBookByKeyword(String keyword);
}
