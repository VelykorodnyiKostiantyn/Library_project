package data_handling.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data_handling.model.Book;


@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(Book book) {}
	@Override
	public void updateBook(Book book) {}
	@Override
	public void deleteBook(Book book) {}
	@Override
	public List<Book> searchBooks(Book book){
		List<Book> books = null;
		return books;
	}
	@Override
	public Book getBook(int ident) {
		Book book = null;
		return book;
	}
	
}
