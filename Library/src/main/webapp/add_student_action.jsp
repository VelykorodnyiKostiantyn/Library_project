<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/add_student.jsp" %>
<body>
<%  
Student student=new Student(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).addStudent(student);
List<Student> st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
for(Student s: st){
	out.println("Details : "+s.getIdent()+" "+s.getFirstName()+" " + s.getLastName()+" "+ s.getEmail());%>
	<br>
	<%
}%>
</body>
</html>