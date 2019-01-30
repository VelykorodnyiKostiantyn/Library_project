package data_handling.service;

import java.util.List;
import data_handling.model.Student;
import data_handling.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentManagerImpl implements StudentManager {
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}
	@Override
	@Transactional
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}
	@Override
	@Transactional
	public void deleteStudent(Student student) {
		studentDAO.deleteStudent(student);
	}
	@Override
	@Transactional
	public List<Student> searchStudent(Student student){
		return studentDAO.searchStudent(student);
	}
	@Override
	@Transactional
	public Student getStudent(int ident) {
		return studentDAO.getStudent(ident);
	}

}
