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
<table>
<tr>
 <th scope="col">ident</th>
 <th scope="col">first name</th>
 <th scope="col">last name</th>

 <th scope="col">email</th>
</tr>
<% 
int ident = Integer.parseInt(request.getParameter("ident"));
int borrowerId = Integer.parseInt(request.getParameter("borrower_id"));
List<Book> books = dataHandler.findBooks(ident, request.getParameter("title"), request.getParameter("author"), borrowerId ); 
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