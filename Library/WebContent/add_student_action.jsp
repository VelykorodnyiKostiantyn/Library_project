<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file = "/include/header.jsp" %>
<body>
<%  
int ident = dataHandler.addStudent(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
Student st = dataHandler.getStudentById(ident);
out.println("Details : "+st.getIdent()+" "+st.getFirstName()+" " + st.getLastName()+" "+ st.getEmail());%>
%>
</body>
</html>