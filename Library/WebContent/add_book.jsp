<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding book</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="add_book_action.jsp">
			 <h1>Enter new book information</h1>
			 <label>title</label>
			 <input type="text" name="title" id="title" />
			 <br>
			 <label>author</label>
			 <input type="text" name="author" id="author" />
			 <br>
			 <button type="submit">Add Book</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>