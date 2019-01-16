<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="data_handling.Student" %>
<%@include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding student</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="add_student_action.jsp">
			 <h1>Enter new student information</h1>
			 <label>first name</label>
			 <input type="text" name="first_name" id="first_name" />
			 <br>
			 <label>last name</label>
			 <input type="text" name="last_name" id="last_name" />
			 <br>
			 <label>email</label>
			 <input type="text" name="email" id="email" />
			 <br>
			 <button type="submit">Add Student</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>