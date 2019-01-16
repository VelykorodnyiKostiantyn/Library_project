<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="data_handling.Student" %>
<%@include file = "/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display all students</title>
</head>
<body>
<% List<Student> st = dataHandler.showStudents(); 
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}

%>
</body>
</html>