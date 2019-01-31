<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/search_book.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display all students</title>
</head>
<body>
<% 
int ident = 0;
int borrowerId =0;

try {
ident = Integer.parseInt(request.getParameter("ident"));
} catch (Exception e) {}
try {
borrowerId = Integer.parseInt(request.getParameter("borrower_id"));
} catch (Exception e) {}
out.print("ident: "+ ident +"borrowerId"+ borrowerId);
Student student= new Student("","", "");
student.setIdent(borrowerId);
Book book = new Book(request.getParameter("title"), request.getParameter("author"));
book.setIdent(ident);
List<Student> s = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
book.setBorrower(s.get(0));
%>
<table>
<tr>
 <th scope="col">ident</th>
 <th scope="col">first name</th>
 <th scope="col">last name</th>

 <th scope="col">email</th>
</tr>
<%
List<Book> books = ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book); 
for(Book b: books){
	%> <tr><td> <%
	out.print(b.getIdent()); 
	%> </td> <td> <% 
	out.print( b.getTitle());
	%> </td> <td> <% 
	out.print(b.getAuthor()); 
	%> </td> <td> <% 
	out.print(b.getBorrower());%>
	</td></tr>
		<%}%>
</table>
</body>
</html>