package data_handling.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import data_handling.dto.BookDto;
import data_handling.dto.StudentDto;
import data_handling.model.Book;
import data_handling.model.Student;
import data_handling.service.ModelDtoMapper;
import mockit.Tested;

public class ModelDtoMapperTest {
	@Tested
	ModelDtoMapper mapper;

	public Student createStudent() {
		Student student = new Student();
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setIdent(1);
		student.setEmail("test@test.com");

		Book b1 = new Book();
		b1.setIdent(1);
		b1.setTitle("title1");
		b1.setAuthor("author1");
		b1.setBorrower(null);
		Book b2 = new Book();
		b2.setIdent(2);
		b2.setTitle("title2");
		b2.setAuthor("author1");
		b2.setBorrower(student);
		Book b3 = new Book();
		b3.setIdent(2);
		Book b4 = new Book();
		Set<Book> books = new HashSet<Book>(Arrays.asList(b1, b2, b3, b4));

		student.setBooks(books);
		return student;
	}

	public StudentDto createStudentDto() {
		StudentDto student = new StudentDto();
		student.setFirstName("Test");
		student.setLastName("Test");
		student.setIdent(1);
		student.setEmail("test@test.com");

		BookDto b1 = new BookDto();
		b1.setIdent(1);
		b1.setTitle("title1");
		b1.setAuthor("author1");
		b1.setBorrowerId(0);
		BookDto b2 = new BookDto();
		b2.setIdent(2);
		b2.setTitle("title2");
		b2.setAuthor("author1");
		b2.setBorrowerId(student.getIdent());
		b2.setBorrowerFirstName(student.getFirstName());
		b2.setBorrowerLastName(student.getLastName());
		BookDto b3 = new BookDto();
		b3.setIdent(2);
		BookDto b4 = new BookDto();
		Set<BookDto> books = new HashSet<BookDto>(Arrays.asList(b1, b2, b3, b4));
		student.setBooks(books);
		return student;
	}

	@Test
	public void testBookToDto() {

	}

	@Test
	public void testBookToModel() {

	}

	@Test
	public void testStudentToDto() throws Exception {
		StudentDto sres = mapper.studentToDto(createStudent());
		StudentDto st = createStudentDto();
		
		assertEquals(st.getFirstName(), sres.getFirstName());
		assertEquals(st.getLastName(), sres.getLastName());
		assertEquals(st.getEmail(), sres.getEmail());
		assertEquals(st.getBooks().size(), sres.getBooks().size());
		for (BookDto b : st.getBooks()) {
			System.out.println(b.getIdent() + " " + b.getTitle() + " " + b.getAuthor() + " " + b.getBorrowerId() + " " + b.getBorrowerFirstName() + " " + b.getBorrowerLastName());			
		}
		System.out.println("result dto");
		for (BookDto b : sres.getBooks()) {
			System.out.println(b.getIdent() + " " + b.getTitle() + " " + b.getAuthor() + " " + b.getBorrowerId() + " " + b.getBorrowerFirstName() + " " + b.getBorrowerLastName());			
		}
	}

	@Test
	public void testStudentToModel() {
		Student sres = mapper.studentToModel(createStudentDto());
		Student st = createStudent();
		
		assertEquals(st.getFirstName(), sres.getFirstName());
		assertEquals(st.getLastName(), sres.getLastName());
		assertEquals(st.getEmail(), sres.getEmail());
		assertEquals(st.getBooks().size(), sres.getBooks().size());
		System.out.println("test model");
		for (Book b : st.getBooks()) {
			System.out.println(
					b.getIdent() + " " + b.getTitle() + " " + b.getAuthor() + " " + b.getBorrower());			
		}
		System.out.println("result model");
		for (Book b : sres.getBooks()) {
			System.out.println(
					b.getIdent() + " " + b.getTitle() + " " + b.getAuthor() + " " + b.getBorrower());		
		}
	}

}
