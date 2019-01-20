<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/search_student.jsp" %>

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
<% 
int ident = Integer.parseInt(request.getParameter("ident"));
List<Student> st = dataHandler.findStudents(ident, request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email") ); 
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