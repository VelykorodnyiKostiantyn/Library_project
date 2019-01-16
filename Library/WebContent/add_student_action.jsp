<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file = "/include/header.jsp" %>
<body>
<%  
out.println("first name: " +request.getParameter("first_name"));
out.println("last name: "+request.getParameter("last_name"));
out.println("email: "+request.getParameter("email"));
dataHandler.addStudent(request.getParameter("first_name"), request.getParameter("last_name"), request.getParameter("email"));
%>
</body>
</html>