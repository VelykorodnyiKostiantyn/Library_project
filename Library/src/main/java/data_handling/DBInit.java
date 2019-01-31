package data_handling;

import org.hibernate.Session;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import data_handling.model.Book;

@Component
public class DBInit {

	@Autowired
	private SessionFactory sessionFactory;
	//initialize database
	
	@Transactional
	public void createTables() {
		Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("CREATE TABLE IF NOT EXISTS STUDENTS (IDENT BIGINT PRIMARY KEY, FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255), EMAIL VARCHAR(255))").executeUpdate();
		session.createSQLQuery("CREATE TABLE IF NOT EXISTS BOOKS (IDENT BIGINT PRIMARY KEY, TITLE VARCHAR(255), AUTHOR VARCHAR(255), FK_STUDENT_IDENT INT)").executeUpdate();		
		session.createSQLQuery("CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1 NOMAXVALUE").executeUpdate();
		session.createSQLQuery("CREATE SEQUENCE IF NOT EXISTS MYSEQ START WITH 1 INCREMENT BY 1 NOMAXVALUE").executeUpdate();
		for (int i : (List<Integer>)session.createSQLQuery("SELECT  * FROM TABLE(ID INT = (NEXTVAL('HIBERNATE_SEQUENCE'),NEXTVAL('HIBERNATE_SEQUENCE')))").list()) {
			System.out.println("next value of HIBERNATE_SEQUENCE: "+ i);			
		}
		
	}
	
	@Transactional
	public void dropTables() {}
	
}
