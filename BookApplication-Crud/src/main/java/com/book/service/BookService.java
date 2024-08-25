package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface BookService {

	Book createBook(Book book);

	Book getBookById(Long id);

	List<Book> getAllBooks();

	Book updateBook(Long id, Book book);

	void deleteBook(Long id);

}
