package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mangvientrieu
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	@GetMapping
	public String hello() {
		return "Hello World!";
	}
}
