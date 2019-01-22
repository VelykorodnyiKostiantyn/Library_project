<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/add_book.jsp" %>
<body>
<%  

int ident = dataHandler.addBook(request.getParameter("title"), request.getParameter("author"));
List<Book> book = dataHandler.findBooks(ident, "", "", 0);
for(Book b: book){
	out.println("Details : "+b.getIdent()+" "+b.getTitle()+" " + b.getAuthor()+" "+ b.getBorrower());%>
	<br>
	<%
}%>
</body>
</html>