<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding student</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="update_student_action.jsp">
			 <h1>Enter student information for update</h1>
			 <label>current ident: </label>
			 <input type="number" name="ident" id="ident" />
			 <label>new first name</label>
			 <input type="text" name="first_name" id="first_name" />
			 <br>
			 <label>new last name</label>
			 <input type="text" name="last_name" id="last_name" />
			 <br>
			 <label>new email</label>
			 <input type="text" name="email" id="email" />
			 <br>
			 <button type="submit">Update Student</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>