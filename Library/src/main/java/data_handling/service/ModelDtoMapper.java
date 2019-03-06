package data_handling.service;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import data_handling.dto.BookDto;
import data_handling.dto.StudentDto;
import data_handling.model.Book;
import data_handling.model.Student;

@Component
public class ModelDtoMapper {

	public BookDto bookToDto(Book book) {
		BookDto bookDto = new BookDto();
		bookDto.setIdent(book.getIdent());
		bookDto.setTitle(book.getTitle());
		bookDto.setAuthor(book.getAuthor());
		if (book.getBorrower() != null) {
		bookDto.setBorrowerId(book.getBorrower().getIdent());
		bookDto.setBorrowerFirstName(book.getBorrower().getFirstName());
		bookDto.setBorrowerLastName(book.getBorrower().getLastName());
		}
		return bookDto;
	}

	public Book bookToModel(BookDto bookDto) {
		Book book = new Book();
		book.setIdent(bookDto.getIdent());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		if (bookDto.getBorrowerId() != 0) {
		Student borrower = new Student();
		borrower.setIdent(bookDto.getBorrowerId());
		book.setBorrower(borrower);
		}
		return book;
	}

	public StudentDto studentToDto(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setIdent(student.getIdent());
		studentDto.setFirstName(student.getFirstName());
		studentDto.setLastName(student.getLastName());
		studentDto.setEmail(student.getEmail());
		HashSet<BookDto> books = new HashSet<BookDto>();
		if (student.getBooks() != null) {
			for (Book b : student.getBooks()) {
				books.add(bookToDto(b));
			}
		}
		studentDto.setBooks(books);
		return studentDto;
	}

	public Student studentToModel(StudentDto studentDto) {
		Student student = new Student();
		student.setIdent(studentDto.getIdent());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		HashSet<Book> books = new HashSet<Book>();
		if (studentDto.getBooks() != null) {
			for (BookDto b : studentDto.getBooks()) {
				books.add(bookToModel(b));
			}
		}
		student.setBooks(books);
		return student;
	}

}
