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

	<form:form action="manage_books" method="post" modelAttribute="form">
		<h3>Managing books for:</h3>
		<form:label path="student.firstName">${student.firstName} </form:label>
		<form:label path="student.lastName">${student.lastName}</form:label>
		<form:hidden path="student.ident"/>
		<h5>Student borrowed books:</h5>
		<form:select path="removeBooksIdent" multiple="true">
			<c:forEach var="b" items="${form.student.books}">
				<form:option value="${b.ident}" selected="selected">${b.title}</form:option>
			</c:forEach>
		</form:select>
		</br>
		<h5>Available books:</h5>
		<form:select path="addBooksIdent" multiple="true">
			<c:forEach var="b" items="${form.addBooks}">
				<form:option value="${b.ident}">${b.title}</form:option>
			</c:forEach>
		</form:select>
		</br>
		<input type="submit" value="save" />
	</form:form>

</body>
</html>