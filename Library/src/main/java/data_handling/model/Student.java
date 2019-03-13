package data_handling.model;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
@SequenceGenerator(
		  name = "STUDENT_SEQ_GENERATOR",
		  sequenceName = "STUDENT_SEQ",
		  initialValue = 1, allocationSize = 1)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ_GENERATOR")
	@Column(name="IDENT")
	private int ident;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@OneToMany(mappedBy="borrower")
	private Set<Book> books;
	
	
	public Student() {}
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
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
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override 
	public int hashCode() {
        return 67*ident;
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return this.getIdent() == student.getIdent();

	}
	
	@Override
	public String toString() {
		return "ident: "+this.getIdent()+", First Name: "+ this.getFirstName() + ", Last Name: "+ this.getLastName() + ", Email: " + this.getEmail();
	}
}
