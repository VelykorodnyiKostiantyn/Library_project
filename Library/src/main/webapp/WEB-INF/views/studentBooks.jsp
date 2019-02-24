<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="include/header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage student books</title>
</head>
<body>

	<h3>Student borrowed books:</h3>
	<form:form action="return_books" method="post" modelAttribute="student">
		<form:select path="books" multiple="true">
			<c:forEach var="b" items="${student.books}">
				<form:option value="${b.title}" selected="selected">${b.title}</form:option>
			</c:forEach>
		</form:select>
		</br>
		<input type="submit" value="return books" />
	</form:form>

	<h3>Available books:</h3>
	<form:form action="borrow_books" method="post" modelAttribute="student">
		<form:select path="books" multiple="true">
			<c:forEach var="b" items="${books}">
				<form:option value="b">${b.title}</form:option>
			</c:forEach>
		</form:select>
		</br>
		<input type="submit" value="add books" />
	</form:form>

</body>
</html>