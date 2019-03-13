package data_handling.test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import data_handling.dao.*;
import data_handling.dto.StudentDto;
import data_handling.model.Student;
import data_handling.service.StudentManagerImpl;

public class StudentManagerTest {

	@Tested(fullyInitialized = true)
	private StudentManagerImpl studentManager;

	@Injectable
	private StudentDAO studentDAO; 

	@Test
	public void testAddStudentMethod() throws Exception {		
		new Expectations() {
			{
				studentDAO.addStudent(createStudent());
			}
		};
		studentManager.addStudent(createStudentDto());

	}

	@Test
	public void testUpdateStudentMethod() throws Exception {
		studentManager.updateStudent(createStudentDto());
		new Verifications() {
			{
				studentDAO.updateStudent(createStudent());
			}
		};
	}

	@Test
	public void testDeleteStudentMethod() throws Exception {
		studentManager.deleteStudent(createStudentDto());
		new Verifications() {
			{
				studentDAO.deleteStudent(createStudent());
			}
		};
	}

	@Test
	public void testSearchStudentMethod() throws Exception {
		List<Student> students = Arrays.asList(createStudent());
		new Expectations() {
			{
				studentDAO.searchStudent(createStudent());
				result = students;
			}
		};
		assertEquals(Arrays.asList(createStudentDto()), studentManager.searchStudent(createStudentDto()));
	}

	@Test
	public void testGetStudentMethod() throws Exception {
		new Expectations() {
			{
				studentDAO.getStudent(createStudent().getIdent());
				result = createStudent();
			}
		};
		assertEquals(createStudentDto(), studentManager.getStudent(createStudent().getIdent()));
	}

	public Student createStudent() {
		Student student = new Student();
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setIdent(1);
		student.setEmail("test@test.com");
		return student;
	}

	public StudentDto createStudentDto() {
		StudentDto student = new StudentDto();
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setIdent(1);
		student.setEmail("test@test.com");
		return student;
	}
}
