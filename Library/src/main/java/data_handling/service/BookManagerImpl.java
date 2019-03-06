package data_handling.service;

import java.util.ArrayList;
import java.util.List;
import data_handling.model.Book;
import data_handling.dao.BookDAO;
import data_handling.dto.BookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
public class BookManagerImpl implements BookManager {
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private ModelDtoMapper mapper;
	
	@Override
	@Transactional
	public void addBook(BookDto bookDto) {
		bookDAO.addBook(mapper.bookToModel(bookDto));
	}
	@Override
	@Transactional
	public void updateBook(BookDto bookDto) {
		bookDAO.updateBook(mapper.bookToModel(bookDto));
	}
	@Override
	@Transactional
	public void deleteBook(BookDto bookDto) {
		bookDAO.deleteBook(mapper.bookToModel(bookDto));
	}
	@Override
	@Transactional
	public List<BookDto> searchBook(BookDto bookDto){
		List<BookDto> books = new ArrayList<BookDto>();
		for (Book b : bookDAO.searchBook(mapper.bookToModel(bookDto))) {
			books.add(mapper.bookToDto(b));
		}
		return books;
	}
	@Override
	@Transactional
	public BookDto getBook(int ident) {
		return mapper.bookToDto(bookDAO.getBook(ident));
	}
	
}
