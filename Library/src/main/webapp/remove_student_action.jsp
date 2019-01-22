<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/remove_student.jsp" %>
<body>
<%  
int ident = Integer.parseInt(request.getParameter("ident"));
List<Student> st = dataHandler.findStudents(ident, "", "", "");
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}
dataHandler.deleteStudent(ident);
%>
</body>
</html>