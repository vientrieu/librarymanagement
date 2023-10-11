package com.example.librarymanagement.dto.book.output;

import com.example.librarymanagement.dto.book.BookInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class BorrowHistoryOutput {
	private Long id;
	private LocalDate borrowDate;
	private LocalDate returnDate;
	private BookInfoDTO bookInfo;
}
