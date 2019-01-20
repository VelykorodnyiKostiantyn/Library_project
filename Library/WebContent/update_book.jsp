<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>changing book</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="update_student_action.jsp">
			 <h1>Enter book information for update</h1>
			 <label>current ident: </label>
			 <input type="number" name="ident" id="ident" />
			 <label>new title</label>
			 <input type="text" name="first_name" id="first_name" />
			 <br>
			 <label>new author</label>
			 <input type="text" name="last_name" id="last_name" />
			 <br>
			 <label>new borrower id</label>
			 <input type="text" name="borrower_id" id="borrower_id" />
			 <br>
			 <button type="submit">Update book</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>