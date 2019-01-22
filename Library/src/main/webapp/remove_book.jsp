<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>removing book</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="remove_book_action.jsp">
			 <h1>Enter id for book you want to delete</h1>
			 <label>ident: </label>
			 <input type="number" name="ident" id="ident" />
			 <button type="submit">Remove Book</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>