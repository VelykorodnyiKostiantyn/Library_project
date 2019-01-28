<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "/include/initialize.jsp" %>
<!DOCTYPE html>
<html>
<body>
		 <form id="search_book" name="search_book" method="post" action="search_book.jsp">
			 <button type="submit">Search Books</button>
		 </form>
		<form id="add_book" name="add_book" method="post" action="add_book.jsp">
			 <button type="submit">Add Book</button>
		 </form>
		 <form id="update_book" name="update_book" method="post" action="update_book.jsp">
			 <button type="submit">Update Book</button>
		 </form>
		 <form id="remove_book" name="remove_book" method="post" action="remove_book.jsp">
			 <button type="submit">Remove Book</button>
		 </form>

		 <form id="search_student" name="search_student" method="post" action="search_student.jsp">
			 <button type="submit">Search Students</button>
		 </form>
		 <form id="add_student" name="add_student" method="post" action="add_student.jsp">
			 <button type="submit">Add Student</button>
		 </form>
		 <form id="update_student" name="update_student" method="post" action="update_student.jsp">
			 <button type="submit">Update Student</button>
		 </form>
		 <form id="remove_student" name="remove_student" method="post" action="remove_student.jsp">
			 <button type="submit">Remove Student</button>
		 </form>


</body>
</html>