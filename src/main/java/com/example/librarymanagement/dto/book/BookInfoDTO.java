package com.example.librarymanagement.dto.book;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class BookInfoDTO {
	private Long bookDistributionId;
	private Long bookId;
	private String name;
	private String shortDescription;
	private LocalDate publishedDate;
	private String authorName;
	private String categoryName;
}
