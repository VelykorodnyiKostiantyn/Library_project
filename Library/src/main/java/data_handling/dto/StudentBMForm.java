package data_handling.dto;

import java.util.Set;

public class StudentBMForm {
	private StudentDto student;
	private Set<BookDto> addBooks;
	private Set<Integer> addBooksIdent;
	private Set<Integer> removeBooksIdent;
	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto studentDto) {
		this.student = studentDto;
	}
	public Set<BookDto> getAddBooks() {
		return addBooks;
	}
	public void setAddBooks(Set<BookDto> addBooks) {
		this.addBooks = addBooks;
	}
	public Set<Integer> getAddBooksIdent() {
		return addBooksIdent;
	}
	public void setAddBooksIdent(Set<Integer> addBooksIdent) {
		this.addBooksIdent = addBooksIdent;
	}
	public Set<Integer> getRemoveBooksIdent() {
		return removeBooksIdent;
	}
	public void setRemoveBooksIdent(Set<Integer> removeBooksIdent) {
		this.removeBooksIdent = removeBooksIdent;
	}
}
