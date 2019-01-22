<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/add_student.jsp" %>
<body>
<%  
int ident = dataHandler.addStudent(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
List<Student> st = dataHandler.findStudents(ident, "", "", "");
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}%>
</body>
</html>