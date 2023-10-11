package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.api.ResponseDto;
import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.dto.book.output.BorrowHistoryOutput;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mangvientrieu
 */
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/borrow-book")
	public ResponseDto<Long> borrowBook(@RequestBody BorrowBookInput input) {
		return ResponseDto.ok(bookService.borrowBook(input));
	}

	@PostMapping("/return-book")
	public ResponseDto<Boolean> returnBook(@RequestBody ReturnBookInput input) {
		return ResponseDto.ok(bookService.returnBook(input));
	}

	@GetMapping("/borrow-history")
	public ResponseDto<List<BorrowHistoryOutput>> getBorrowHistory() {
		return ResponseDto.ok(bookService.getBorrowHistory());
	}
}