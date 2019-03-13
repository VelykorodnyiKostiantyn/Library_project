package data_handling.dto;


public class BookDto {

	private int ident;
	private String title;
	private String author;
	private int borrowerId;
	private String borrowerFirstName;
	private String borrowerLastName;
	
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
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getBorrowerFirstName() {
		return borrowerFirstName;
	}
	public void setBorrowerFirstName(String borrowerFirstName) {
		this.borrowerFirstName = borrowerFirstName;
	}
	public String getBorrowerLastName() {
		return borrowerLastName;
	}
	public void setBorrowerLastName(String borrowerLastName) {
		this.borrowerLastName = borrowerLastName;
	}
	public boolean equals(BookDto bookDto) {
		return this.getIdent() == bookDto.getIdent() ? true: false;
	}
	
	@Override 
	public int hashCode() {
        return 71*ident;
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BookDto book = (BookDto) obj;
        return this.getIdent() == book.getIdent();

	}

}
