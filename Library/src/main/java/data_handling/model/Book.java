package data_handling.model;
import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@SequenceGenerator(
		  name = "BOOK_SEQ_GENERATOR",
		  sequenceName = "BOOK_SEQ",
		  initialValue = 1, allocationSize = 1)
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ_GENERATOR")
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
	
	@Override 
	public int hashCode() {
        return 61*ident;
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this.getIdent() == book.getIdent();

	}
	
	@Override
	public String toString() {
		String result = "ident: "+this.getIdent()+", Title: "+ this.getTitle() + ", Author: "+ this.getAuthor() + ", Borrower: ";
		if (this.getBorrower() != null) {
			result += this.getBorrower().getIdent();
			//result += this.getBorrower().toString();
		}
		return result;
	}
}
