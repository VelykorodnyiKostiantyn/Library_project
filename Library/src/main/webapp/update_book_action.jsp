<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@ include file = "/update_book.jsp" %>
<body>
<%  
int ident = Integer.parseInt(request.getParameter("ident"));
List<Book> books = dataHandler.findBooks(ident, "", "", 0);
for(Book b: books){
	out.println("Details : "+b.getIdent()+" "+b.getTitle()+" " + b.getAuthor()+" "+ b.getBorrower());%>
	<br>
	<%
}
dataHandler.updateStudent(ident,request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
books = dataHandler.findBooks(ident, "", "", 0);
for(Book b: books){
	out.println("Details : "+b.getIdent()+" "+b.getTitle()+" " + b.getAuthor()+" "+ b.getBorrower());%>
	<br>
	<%
}
%>
</body>
</html>