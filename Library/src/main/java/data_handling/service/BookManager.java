package data_handling.service;

import java.util.List;

import data_handling.dto.BookDto;

public interface BookManager {
	public void addBook(BookDto bookDto);
	public void updateBook(BookDto bookDto);
	public void deleteBook(BookDto bookDto);
	public List<BookDto> searchBook(BookDto bookDto);
	public BookDto getBook(int ident);
}
