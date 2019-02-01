<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/remove_book.jsp" %>
<body>
<%  
int ident = 0;
Book book = new Book("", "");

try {
ident = Integer.parseInt(request.getParameter("ident"));
if (ident > 0)
{book.setIdent(ident);
for(Book b: ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).searchBooks(book)){
	out.println(b.toString());
	ApplicationContextProvider.getApplicationContext().getBean(BookManager.class).deleteBook(b);
	%><br><%
}
} else {out.println("Wrong Book identifier");}
} catch (Exception e) {
	e.printStackTrace();
}


%>
</body>
</html>