<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@ include file = "/update_book.jsp" %>
<body>
<%  
int ident = 0;
int borrowerId =0;
List<Book> books;
Book book = new Book("","");



try {
ident = Integer.parseInt(request.getParameter("ident"));
book.setIdent(ident);
books = ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book);
for(Book b: books){
	out.println(b.toString());%>
	<br>
	<%
	book.setTitle(request.getParameter("title"));
	book.setAuthor(request.getParameter("author"));
}

try {
borrowerId = Integer.parseInt(request.getParameter("borrower_id"));
Student student= new Student("","", "");
student.setIdent(borrowerId);
List<Student> s = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
book.setBorrower(s.get(0));
} catch (Exception e) { 
	out.print("Student not found");
}

ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).updateBook(book);

books = ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book);
for(Book b: books){
	out.println("NEW: "+b.toString());%>
	<br>
	<%
}

} catch (Exception e) {
	out.print("Book not found");
}
out.print("ident: "+ ident +"borrowerId"+ borrowerId);


%>
</body>
</html>