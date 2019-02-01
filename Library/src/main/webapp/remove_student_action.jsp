<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@include file = "/include/header.jsp" --%>
<%@include file = "/remove_student.jsp" %>
<body>
<%  
int ident = 0;
Student student = new Student("","","");
try {
ident = Integer.parseInt(request.getParameter("ident"));
student.setIdent(ident);
List<Student> st = ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).searchStudent(student);
for(Student s: st){
	out.println(s.toString());
	ApplicationContextProvider.getApplicationContext().getBean(StudentManager.class).deleteStudent(s);
	%><br><%
}
} catch (Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>