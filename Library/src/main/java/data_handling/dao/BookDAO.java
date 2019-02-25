package data_handling.dao;
import java.util.List;
import data_handling.model.Book;

public interface BookDAO {
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Book book);
	public List<Book> searchBook(Book book);
	public Book getBook(int ident);
}
