package data_handling.test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data_handling.dao.*;
import data_handling.model.Student;
import data_handling.service.StudentManager;


public class StudentManagerTest {

	@Tested
	private StudentManager studentManager;
	
	@Injectable
	private StudentDAO studentDAO;

	
	
	@Test
	public void testAddStudentMethod () {
		System.out.println(createStudent());
		new Expectations() {{
			studentDAO.addStudent(createStudent());
		}};		
		studentManager.addStudent(createStudent());
		
	}
	
	@Test
	public void testUpdateStudentMethod () {
		new Verifications() {{
			studentDAO.updateStudent(createStudent());
		}};		
		studentManager.updateStudent(createStudent());	
	}
	
	@Test
	public void testDeleteStudentMethod () {
		studentManager.deleteStudent(createStudent());
		new Verifications() {{
			studentDAO.deleteStudent(createStudent());
		}};			
	}
	
	@Test
	public void testSearchStudentMethod () {
		List<Student> students =new ArrayList<Student>(Arrays.asList(createStudent()));
		new Expectations(){{
			studentDAO.searchStudent(createStudent());
			result= students;
		}};
		assertEquals(students, studentManager.searchStudent(createStudent()));
	}
	
	@Test
	public void testGetStudentMethod () {
		new Expectations() {{
			studentDAO.getStudent(createStudent().getIdent()); result = createStudent();
		}};
		assertEquals(createStudent(), studentManager.getStudent(createStudent().getIdent()));
	}
	
	public Student createStudent() {
		Student student = new Student();
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setIdent(1);
		student.setEmail("test@test.com");
		return student;
	}
	
}
