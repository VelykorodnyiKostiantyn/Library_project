<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@ include file = "/update_student.jsp" %>
<body>
<% 
int ident = 0;
Student student = new Student("","","");
List<Student> st;
try {
ident = Integer.parseInt(request.getParameter("ident"));
student.setIdent(ident);
st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
for(Student s: st){
	out.println(s.toString());%>
	<br>
	<%
}

student.setFirstName(request.getParameter("first_name"));
student.setLastName(request.getParameter("last_name"));
student.setEmail(request.getParameter("email"));
ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).updateStudent(student);
st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
for(Student s: st){
	out.println(s.toString());%>
	<br>
	<%
}
} catch (Exception e) {
	e.printStackTrace();
}

%>
</body>
</html>