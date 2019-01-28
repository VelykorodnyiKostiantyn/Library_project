package data_handling.dao;

import java.util.List;
import data_handling.model.Student;

public interface StudentDAO {
	public void addStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Student student);
	public List<Student> searchStudent(Student student);
	public Student getStudent(int ident);
}
