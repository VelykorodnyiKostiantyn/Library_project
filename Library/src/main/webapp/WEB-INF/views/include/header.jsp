<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--     <%@ include file = "/include/initialize.jsp" %> --%>
<!DOCTYPE html>
<html>
<body>
	<table>
		<tr>
			<td>
				<form id="search_book" name="search_book" method="GET"
					action="/Library/books">
					<button type="submit">Search Books</button>
				</form>
			</td>
			<td>
				<form id="add_book" name="add_book" method="GET"
					action="/Library/books/new">
					<button type="submit">Add Book</button>
				</form>
			</td>
			<td>
				<form id="search_student" name="search_student" method="GET"
					action="/Library/students">
					<button type="submit">Search Students</button>
				</form>
			</td>
			<td>
				<form id="add_student" name="add_student" method="GET"
					action="/Library/students/new">
					<button type="submit">Add Student</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>