<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file = "/include/header.jsp" %>
<body>
<%  
int ident = Integer.parseInt(request.getParameter("ident"));
List<Student> st = dataHandler.findStudents(ident, "", "", "");
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}
dataHandler.updateStudent(ident,request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
st = dataHandler.findStudents(ident, "", "", "");
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}
%>
</body>
</html>