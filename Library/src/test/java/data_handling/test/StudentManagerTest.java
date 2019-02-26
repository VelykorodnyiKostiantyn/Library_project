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

import data_handling.dao.StudentDAO;
import data_handling.model.Student;
import data_handling.service.StudentManager;

@RunWith(JMockit.class)
public class StudentManagerTest {

	@Tested
	private StudentManager studentManager;
	
	@Injectable
	private StudentDAO studentDAO;
	
	@Test
	public void testAddStudentMethod (@Mocked Student student) {
		studentManager.addStudent(student);
		new Verifications() {{
			studentDAO.addStudent(student);
		}};				
	}
	
	@Test
	public void testUpdateStudentMethod (@Mocked Student student) {
		studentManager.updateStudent(student);
		new Verifications() {{
			studentDAO.updateStudent(student);
		}};			
	}
	
	@Test
	public void testDeleteStudentMethod (@Mocked Student student) {
		studentManager.deleteStudent(student);
		new Verifications() {{
			studentDAO.deleteStudent(student);
		}};			
	}
	
	@Test
	public void testSearchStudentMethod (@Mocked Student student) {
		List<Student> students =new ArrayList<Student>(Arrays.asList(student));
		new Expectations(){{
			studentDAO.searchStudent(student);result= students;
		}};
		assertEquals(students, studentManager.searchStudent(student));
	}
	
	@Test
	public void testGetStudentMethod () {
		int ident = 2;
		Student student = new Student();
		student.setIdent(ident);
		new Expectations() {{
			studentDAO.getStudent(ident); result = student;
		}};
		assertEquals(student, studentManager.getStudent(ident));
	}
	
}
