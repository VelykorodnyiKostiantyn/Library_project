package data_handling.dao;

import java.util.List;

import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data_handling.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().persist(student);
	}
	@Override
	public void updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}
	@Override
	public void deleteStudent(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}
	@Override
	public List<Student> searchStudent(Student student) {
		List<Student> students = null;
		Session session = sessionFactory.getCurrentSession();		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
		 		CriteriaQuery<Student> qry = criteriaBuilder.createQuery(Student.class); 
		 		Root<Student> root = qry.from(Student.class);		 
		 		Predicate conditions =criteriaBuilder.and(criteriaBuilder.like( root.get("firstName"), wrapToLike(student.getFirstName())), 
		 				criteriaBuilder.like( root.get("lastName"), wrapToLike(student.getLastName())), 
		 				criteriaBuilder.like( root.get("email"), wrapToLike(student.getEmail()))); 
		 		if (student.getIdent() >0 ) { 
		 		conditions=criteriaBuilder.and(conditions, criteriaBuilder.equal(root.get("ident"), student.getIdent())); 
		 		} 
		qry.select(root).where(conditions);		 
		students =(List<Student>)session.createQuery(qry).list();
		return students;			
	}
	
	//doesn't work properly, lazy fetch issue
	//any way to fix it aside from eager fetch?	
	@Override
	public Student getStudent(int ident) {
		Student student = null;
		student = (Student)sessionFactory.getCurrentSession().load(Student.class, ident);
		return student;
	}
	
	//utility function
	public static String wrapToLike(String value) {
	    return value == null ? "%" : "%"+value+"%";
	}	
	
}
