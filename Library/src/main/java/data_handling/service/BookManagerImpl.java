package data_handling.service;

import java.util.List;
import data_handling.model.Book;
//can autowired do import automatically?
import data_handling.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
public class BookManagerImpl implements BookManager {
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}
	@Override
	@Transactional
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}
	@Override
	@Transactional
	public void deleteBook(Book book) {
		bookDAO.deleteBook(book);
	}
	@Override
	@Transactional
	public List<Book> searchBooks(Book book){
		return bookDAO.searchBooks(book);
	}
	@Override
	@Transactional
	public Book getBook(int ident) {
		return bookDAO.getBook(ident);
	}

}
