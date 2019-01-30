package data_handling.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		Criteria criteria = session.createCriteria(Student.class)
				.add(Restrictions.like("firstName", wrapToLike(student.getFirstName())))
				.add(Restrictions.like("lastName", wrapToLike(student.getLastName())))
				.add(Restrictions.like("email", wrapToLike(student.getEmail())))
				.add(Restrictions.like("ident", student.getIdent()))
				;	
		students = criteria.list();
		return students;			
	}
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
