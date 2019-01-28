package data_handling;

import java.util.List;
//import javax.persistence.criteria.*;
//import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import data_handling.model.*;

public class DataHandler {


	public static void main(String[] args) {
		
		DataHandler dh = new DataHandler();
		dh.createTables();

		dh.addStudent("Sam","Disilva","sd@backpedal.sk");
		dh.addStudent("Joshua", "Brill", "jb@g.com");
		dh.addStudent("Peter", "Pan", "PPP@neverland.gov");
		int student1 =dh.addStudent("James", "Bond", "bond007@mi6.gov.gb");
		int student2 =dh.addStudent("John", "Doe", "A047@agency.com");
		Book book1 = new Book("aaa","ccc");
		List<Student> students = dh.showStudents();
		for(Student s: students){
			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());

		}

		dh.updateStudent(student1,"", "", "anonimous007@mi6.gov.gb");
		dh.deleteStudent(student2);
		
		students = dh.showStudents();
		for(Student s: students){
			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());

		}
		
		students = dh.findStudents(1,"" ,"sil","");
		for(Student s: students){
			System.out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());

		}
	}
	//initialize database
	public void createTables() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//session.createSQLQuery("DROP TABLE STUDENTS").executeUpdate();
		//session.createSQLQuery("DROP TABLE BOOKS").executeUpdate();		
		
		session.createSQLQuery("CREATE TABLE IF NOT EXISTS STUDENTS (IDENT BIGINT PRIMARY KEY, FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255), EMAIL VARCHAR(255))").executeUpdate();
		session.createSQLQuery("CREATE TABLE IF NOT EXISTS BOOKS (IDENT BIGINT PRIMARY KEY, TITLE VARCHAR(255), AUTHOR VARCHAR(255), FK_STUDENT_IDENT INT)").executeUpdate();		
		session.createSQLQuery("CREATE SEQUENCE IF NOT EXISTS HIBERNATE_SEQUENCE").executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	//modify Students table
	public int addStudent(String firstName, String lastName, String email) {
		Student student = new Student(firstName, lastName, email);	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		session.close(); 
		return student.getIdent();
	}
	
	public void updateStudent(int ident, String firstName, String lastName, String email) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student student = (Student)session.load(Student.class, ident);		
		if (firstName != "" && firstName != null) {student.setFirstName(firstName);}
		if (lastName != "" && lastName != null) {student.setLastName(lastName);}
		if (email != "" && email != null) {student.setEmail(email);}
		session.persist(student);
		session.getTransaction().commit();
		session.close(); 			
	}
	
	public void deleteStudent(int ident) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student student = (Student)session.load(Student.class, ident);
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
	
	//get Student objects from db
	public List<Student> showStudents(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> students =(List<Student>)session.createQuery("from Student ").list();
		session.close();
		return students;
	}
	
	public List<Student> findStudents(int ident, String firstName, String lastName, String email){
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.like("firstName", wrapToLike(firstName)))
				.add(Restrictions.like("lastName", wrapToLike(firstName)))
				.add(Restrictions.like("email", wrapToLike(firstName)))
				;
		if (ident > 0 ) {
			criteria.add(Restrictions.eq("ident", ident));
		}	

		List<Student> students = criteria.list();
		session.close();
		return students;
	}
	
	public Student getStudentById(int ident) {
		Student student = null;
		System.out.print("find student by id");
		Session session = HibernateUtil.getSessionFactory().openSession();		
		student = (Student)session.load(Student.class, ident);
		session.close();
		System.out.print("have a student");
		return student;		
	}
	
	
	//modify Books table
	
	public int addBook(String title, String author) {
		Book book = new Book(title, author);	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(book);
		session.getTransaction().commit();
		session.close(); 
		return book.getIdent();
	}
	
	public void updateBook(int ident, String title, String author, int student_ref) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Book book = (Book)session.load(Book.class, ident);		
		if (title != "" && title != null) {book.setTitle(title);}
		if (author != "" && author != null) {book.setAuthor(author);}
		if (student_ref >0) {book.setBorrower((Student)session.load(Student.class, student_ref));}
		session.persist(book);
		session.getTransaction().commit();
		session.close(); 			
	}
	
	public void deleteBook(int ident) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Book book = (Book)session.load(Book.class, ident);
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}
	
	public void relateBook(int ident, int student_ref) {
		this.updateBook(ident, "", "", student_ref);
	}
	
	//get Book objects from db
	public List<Book> showBooks(){
		return findBooks(0,"","",0);
	}
	public List<Book> findBooks(int ident, String title, String author, int student_ref ){
		Session session = HibernateUtil.getSessionFactory().openSession();		
		Criteria criteria = session.createCriteria(Book.class)
				.add(Restrictions.like("title", wrapToLike(title)))
				.add(Restrictions.like("author", wrapToLike(author)))
				;
		if (ident > 0 ) {
			criteria.add(Restrictions.eq("ident", ident));
		}	
		if (student_ref >0 ) {
			criteria.add(Restrictions.eq("student_ref", student_ref));
		}
		session.beginTransaction();
		List<Book> books =(List<Book>)criteria.list();

		session.close();
		return books;
	}
	public Book getBookById(int ident) {
		Book book = null;
		Session session = HibernateUtil.getSessionFactory().openSession();		
		book = (Book)session.load(Book.class, ident);
		session.close();
		return book;	
	}
	public List<Book> findBooksByStudent(int student_ref){
		return this.findBooks(0, "", "", student_ref);
	}
		
	//utility function
	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}
	
}
