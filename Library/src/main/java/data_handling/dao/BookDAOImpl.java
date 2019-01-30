package data_handling.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data_handling.HibernateUtil;
import data_handling.model.Book;
import data_handling.model.Student;


@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().persist(book);
	}
	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}
	@Override
	public void deleteBook(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}
	@Override
	public List<Book> searchBooks(Book book){
		List<Book> books = null;
		Session session = sessionFactory.getCurrentSession();		
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.like("title", wrapToLike(book.getTitle())))
				.add(Restrictions.like("author", wrapToLike(book.getAuthor())))
				.add(Restrictions.like("borrower", book.getBorrower()))
				.add(Restrictions.like("ident", book.getIdent()))
				;	
		books = criteria.list();
		return books;
	}
	@Override
	public Book getBook(int ident) {
		Book book = null;
		return book;
	}
	
	//utility function
	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}
}


