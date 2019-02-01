<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display all students</title>
</head>
<body>
<table>
<tr>
 <th scope="col">ident</th>
 <th scope="col">first name</th>
 <th scope="col">last name</th>

 <th scope="col">email</th>
</tr>
<% List<Student> st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(new Student("","","")); 
for(Student s: st){
	%> <tr><td> <%
	out.print(s.getIdent()); 
	%> </td> <td> <% 
	out.print( s.getFirstName());
	%> </td> <td> <% 
	out.print(s.getLastName()); 
	%> </td> <td> <% 
	out.print(s.getEmail());%>
	</td></tr>
		<%}%>
</table>
</body>
</html>