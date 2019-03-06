package data_handling.dao;

import java.util.List;

import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data_handling.model.Book;


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
	public List<Book> searchBook(Book book){
		List<Book> books = null;
		Session session = sessionFactory.getCurrentSession();		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
		 		CriteriaQuery<Book> qry = criteriaBuilder.createQuery(Book.class); 
		 		Root<Book> root = qry.from(Book.class);		 
		 		Predicate conditions =criteriaBuilder.and(criteriaBuilder.like( root.get("title"), wrapToLike(book.getTitle())), 
		 				criteriaBuilder.like( root.get("author"), wrapToLike(book.getAuthor()))); 
		 		if (book.getIdent() >0 ) { 
		 		conditions=criteriaBuilder.and(conditions, criteriaBuilder.equal(root.get("ident"), book.getIdent())); 
		 		} 
		 		if (book.getBorrower() != null ) { 	 			
		 		conditions=criteriaBuilder.and(conditions, criteriaBuilder.equal(root.get("borrower"), book.getBorrower())); 
		 		} 
		 		qry.select(root).where(conditions);		 
		books = (List<Book>)session.createQuery(qry).list();
		return books;
	}
	@Override
	public Book getBook(int ident) {
		Book book = null;
		book = (Book)sessionFactory.getCurrentSession().get(Book.class, ident);
		return book;
	}
	
	//utility function
	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}
}


