package data_handling.dto;

import java.util.Set;



public class StudentDto {
	private int ident;
	private String firstName;
	private String lastName;
	private String email;
	private Set<BookDto> books;
	public int getIdent() {
		return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<BookDto> getBooks() {
		return books;
	}
	public void setBooks(Set<BookDto> books) {
		this.books = books;
	}
	public boolean equals(StudentDto studentDto) {
		return this.getIdent() == studentDto.getIdent() ? true: false;
	}
		
}
