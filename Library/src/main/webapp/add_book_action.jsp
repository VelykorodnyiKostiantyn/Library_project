<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/add_book.jsp" %>
<body>
<%  

Book book =new Book(request.getParameter("title"), request.getParameter("author"));
ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).addBook(book);
for(Book b: ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book)){
	out.println(b.toString());
	%><br><%
}%>
</body>
</html>