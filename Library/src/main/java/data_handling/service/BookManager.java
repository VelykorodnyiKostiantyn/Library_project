package data_handling.service;

import java.util.List;
import data_handling.model.Book;

public interface BookManager {
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Book book);
	public List<Book> searchBooks(Book book);
	public Book getBook(int ident);
}
