package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.dto.book.output.BorrowHistoryOutput;

import java.util.List;

/**
 * @author mangvientrieu
 */
public interface BookService {
	Long borrowBook(BorrowBookInput input);

	boolean returnBook(ReturnBookInput input);

	List<BorrowHistoryOutput> getBorrowHistory();
}
