<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/remove_book.jsp" %>
<body>
<%  
int ident = 0;
try {
ident = Integer.parseInt(request.getParameter("ident"));
} catch (Exception e) {}
Book book = new Book("", "");
book.setIdent(ident);
for(Book b: ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book)){
	out.println(b.toString());
	ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).deleteBook(b);
	%><br><%
}
%>
</body>
</html>