<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search book</title>
</head>
<body>

<div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="search_book_action.jsp">
			 <h1>Enter book information for update</h1>
			 <label>ident: </label>
			 <input type="number" name="ident" id="ident" />
			 <label>title</label>
			 <input type="text" name="title" id="title" />
			 <br>
			 <label>author</label>
			 <input type="text" name="author" id="author" />
			 <br>
			 <label>borrowing student ident</label>
			 <input type="number" name="borrower_id" id="borrower_id" />
			 <br>
			 <button type="submit">Find Books</button>
			 <div class="spacer"></div>
		 </form>
	 </div>

</body>
</html>