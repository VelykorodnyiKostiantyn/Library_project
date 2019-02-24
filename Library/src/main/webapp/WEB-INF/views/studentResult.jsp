<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="include/header.jsp"%>
<body>
	<h2>Submitted Student Information</h2>
	<table>
		<tr>
			<td>First Name :</td>
			<td>${firstName}</td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td>${lastName}</td>
		</tr>
		<tr>
			<td>email :</td>
			<td>${email}</td>
		</tr>
	</table>


</body>
</html>