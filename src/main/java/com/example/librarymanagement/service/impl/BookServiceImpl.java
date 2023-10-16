package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.book.input.BorrowBookInput;
import com.example.librarymanagement.dto.book.input.ReturnBookInput;
import com.example.librarymanagement.entity.BookDistributionEntity;
import com.example.librarymanagement.entity.BookEntity;
import com.example.librarymanagement.entity.BookManagementEntity;
import com.example.librarymanagement.entity.UserEntity;
import com.example.librarymanagement.exception.BusinessException;
import com.example.librarymanagement.repository.BookDistributionRepository;
import com.example.librarymanagement.repository.BookManagementRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.UserRepository;
import com.example.librarymanagement.repository.projection.BorrowHistoryProjection;
import com.example.librarymanagement.service.BookService;
import com.example.librarymanagement.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * @author mangvientrieu
 */
@Service
public class BookServiceImpl implements BookService {
	public static final String ENABLE = "ENABLE";
	public static final String BORROW = "BORROW";
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookDistributionRepository bookDistributionRepository;
	@Autowired
	private BookManagementRepository bookManagementRepository;
	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional
	public Long borrowBook(BorrowBookInput input) {
		Long bookId = input.getBookId();
		Long userId = AuthUtil.getUserId();
		UserEntity user = userRepository.findById(userId).orElseThrow(
				() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));
		BookDistributionEntity bookDistribution = bookDistributionRepository.findFirstByBookIdAndStatus(bookId,
				ENABLE).orElseThrow(() -> new BusinessException("BOOK_UNAVAILABLE", "Thư viện đã hết sách mà bạn tìm"));
		bookDistribution.setStatus(BORROW);
		BookManagementEntity bookManagement = BookManagementEntity.builder()
				.user(user)
				.bookDistribution(bookDistribution)
				.borrowDate(LocalDate.now())
				.returnDate(null)
				.build();
		BookManagementEntity saved = bookManagementRepository.save(bookManagement);
		return saved.getId();
	}

	@Override
	public boolean returnBook(ReturnBookInput input) {
		Long userId = AuthUtil.getUserId();
		List<BookManagementEntity> bookManagements = bookManagementRepository.findBorrowInformation(userId,
				input.getBookDistributionId());
		if (CollectionUtils.isEmpty(bookManagements)) {
			throw new BusinessException("INFORMATION_NOT_FOUND", "Thông tin mượn sách không được tìm thấy");
		} else if (bookManagements.size() > 1) {
			throw new BusinessException("INFORMATION_INCORRECT",
					"Thông tin mượn sách không hợp lệ. Vui lòng kiểm tra lại");
		} else {
			BookManagementEntity bookManagement = bookManagements.get(0);
			bookManagement.setReturnDate(LocalDate.now());
			bookManagement.getBookDistribution().setStatus(ENABLE);
			bookManagementRepository.save(bookManagement);
		}
		return true;
	}

	@Override
	public Page<BorrowHistoryProjection> getBorrowHistory(int page, int size) {
		Long userId = AuthUtil.getUserId();
		return bookManagementRepository.findBorrowHistory(userId,
				PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate")));
	}

	@Override
	public List<BookEntity> searchBookByKeyword(String keyword) {
		return bookRepository.searchBookByKeyword(keyword);
	}
}
