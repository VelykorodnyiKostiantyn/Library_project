<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="include/header.jsp"%>
<body>
	<h2>Submitted Book Information</h2>
	<table>
		<tr>
			<td>Title :</td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td>Author :</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td>Borrower Id :</td>
			<td>${book.borrowerId}</td>
		</tr>
</table>
</body>
</html>