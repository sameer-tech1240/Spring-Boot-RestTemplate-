package com.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.exception.BookNotFoundException;
import com.book.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * private static final Logger logger =
	 * LoggerFactory.getLogger(BookServiceImpl.class);
	 */

	@Override
	public Book createBook(Book book) {
		validateBook(book);
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long id) {
		validateId(id);
		log.error("Error Occurred for id  {}", id);
		log.debug("Debug logger is running...");
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Long id, Book book) {
		validateId(id);
		validateBook(book);
		if (!bookRepository.existsById(id)) {
			throw new BookNotFoundException("Book not found with ID: " + id);
		}
		book.setId(id);
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		validateId(id);
		if (!bookRepository.existsById(id)) {
			throw new BookNotFoundException("Book not found with ID: " + id);
		}
		bookRepository.deleteById(id);
	}

	private void validateBook(Book book) {
		if (book == null || book.getTitle() == null || book.getAuthor() == null) {
			throw new IllegalArgumentException("Book details cannot be null");
		}
	}

	private void validateId(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Book ID must be a positive number");
		}
	}
}
