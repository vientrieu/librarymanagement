package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.api.ResponseDto;
import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.entity.BookEntity;
import com.example.librarymanagement.repository.projection.BorrowHistoryProjection;
import com.example.librarymanagement.repository.projection.CountBookProjection;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseDto<Page<BorrowHistoryProjection>> getBorrowHistory(@RequestParam(defaultValue = "0") int page,
	                                                                   @RequestParam(defaultValue = "30") int size) {
		return ResponseDto.ok(bookService.getBorrowHistory(page, size));
	}

	@GetMapping("/search")
	public ResponseDto<List<BookEntity>> getBorrowHistory(@RequestParam(defaultValue = "") String keyword) {
		return ResponseDto.ok(bookService.searchBookByKeyword(keyword));
	}

	@PostMapping("/import")
	public ResponseDto<List<BookEntity>> importBookFromExcel(@RequestParam("file") MultipartFile file) {
		return ResponseDto.ok(bookService.importBookFromExcel(file));
	}

	@GetMapping("/count-total")
	public ResponseDto<List<CountBookProjection>> countTotalBook() {
		return ResponseDto.ok(bookService.countTotalBook());
	}

	@GetMapping("/count-existed")
	public ResponseDto<List<CountBookProjection>> countExistedBook() {
		return ResponseDto.ok(bookService.countExistedBook());
	}
}
