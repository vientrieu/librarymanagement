package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.api.ResponseDto;
import com.example.librarymanagement.entity.BookEntity;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mangvientrieu
 */
@RestController
@RequestMapping("/admin/book")
public class AdminBookController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseDto<List<BookEntity>> get() {
		return ResponseDto.ok(bookService.read());
	}

	@PostMapping
	public ResponseDto<BookEntity> create(@RequestBody BookEntity input) {
		return ResponseDto.ok(bookService.create(input));
	}

	@PutMapping
	public ResponseDto<BookEntity> update(@RequestBody BookEntity input) {
		return ResponseDto.ok(bookService.update(input));
	}

	@DeleteMapping("/{id}")
	public ResponseDto<Boolean> delete(@PathVariable("id") Long id) {
		return ResponseDto.ok(bookService.delete(id));
	}

}
