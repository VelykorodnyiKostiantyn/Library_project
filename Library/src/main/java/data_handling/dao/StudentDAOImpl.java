package data_handling.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data_handling.model.Student;

public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStudent(Student student) {}
	@Override
	public void updateStudent(Student student) {}
	@Override
	public void deleteStudent(Student student) {}
	@Override
	public List<Student> searchStudent(Student student) {
		List<Student> students = null;
		return students;			
	}
	@Override
	public Student getStudent(int ident) {
		Student student = null;
		return student;
	}
	
}
