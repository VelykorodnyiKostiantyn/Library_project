package data_handling;

import java.util.List;

import javax.persistence.criteria.*;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Criteria;

public class DataHandler {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		DataHandler dh = new DataHandler();
		dh.createTables();

		Student student1 = new Student("Sam","Disilva","Maths");
		Student student2 = new Student("Joshua", "Brill", "Science");
		Student student3 = new Student("Peter", "Pan", "Physics");

		Book book1 = new Book("aaa","ccc");
		

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(book1);
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);

		List<Student> students = dh.showStudents();
		for(Student s: students){
			System.out.println("Details : "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());

		}
		
		students = dh.findStudents(1,"" ,"sil","");
		for(Student s: students){
			System.out.println("Details : "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());

		}

		session.getTransaction().commit();
		session.close();  
	}
	
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
	
	public void addStudent(String firstName, String lastName, String email) {
		Student st = new Student(firstName, lastName, email);	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(st);
		session.getTransaction().commit();
		session.close();  
	}
	
	public void updateStudent(int ident, String firstName, String lastName, String email) {
				
	}
	
	public void deleteStudent(int ident) {
				
	}
	
	public List<Student> showStudents(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> students =(List<Student>)session.createQuery("from Student ").list();
		session.close();
		return students;
	}
	
	public List<Student> findStudents(int ident, String firstName, String lastName, String email){

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> qry = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = qry.from(Student.class);		
		Predicate conditions =criteriaBuilder.and(criteriaBuilder.like( root.get("firstName"), wrapToLike(firstName)),
				criteriaBuilder.like( root.get("lastName"), wrapToLike(lastName)),
				criteriaBuilder.like( root.get("email"), wrapToLike(email)));
		qry.select(root).where(conditions);
		
		session.beginTransaction();
		List<Student> students =(List<Student>)session.createQuery(qry).list();

		session.close();
		return students;
	}
	
	
	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}


}
