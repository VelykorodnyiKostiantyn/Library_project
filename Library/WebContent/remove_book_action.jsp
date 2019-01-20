<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/remove_book.jsp" %>
<body>
<%  
int ident = Integer.parseInt(request.getParameter("ident"));
List<Book> books = dataHandler.findBooks(ident, "", "", 0);
for(Book b: books){
	out.println("Details : "+b.getIdent()+" "+b.getTitle()+" " + b.getAuthor()+" "+ b.getBorrower());%>
	<br>
	<%
}
dataHandler.deleteBook(ident);
%>
</body>
</html>