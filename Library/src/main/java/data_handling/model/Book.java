package data_handling.model;
import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {
	@Id 
	@GeneratedValue
	@Column(name="ident")
	private int ident;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@ManyToOne(optional = true)
    @JoinColumn(name="FK_STUDENT_IDENT")
	private Student borrower; 
	
	public int getIdent() {
			return ident;
	}
	public void setIdent(int ident) {
		this.ident = ident;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Student getBorrower() {
		return borrower;
	}
	public void setBorrower(Student borrower) {
		this.borrower = borrower;
	}
	
	public Book() {}
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}
