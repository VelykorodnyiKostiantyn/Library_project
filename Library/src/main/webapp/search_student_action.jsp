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
int ident = 0;
try {
ident = Integer.parseInt(request.getParameter("ident"));
} catch (Exception e) {}

Student student = new Student(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
student.setIdent(ident);
List<Student> st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
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