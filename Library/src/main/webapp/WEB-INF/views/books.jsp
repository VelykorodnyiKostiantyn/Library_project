<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
        <form:form method="POST"
          action="books" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
					<td><form:label path="author">Author</form:label></td>
                </tr>
                <tr>
                    <td><form:input path="title"/></td>
                    <td><form:input path="author"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="search"/></td>
                </tr>
            </table>
        </form:form>
            <table>
                <tr>
                <td>ident</td>
                    <td>Title</td>
					<td>Author</td>
					<td>Borrowed by:</td>
                </tr>
                <c:forEach var="b" items="${books}">
                <tr>
                	<td><c:out value="${b.ident}"></c:out></td>
                    <td><c:out value="${b.title}" /> </td>
                    <td><c:out value="${b.author}" /> </td>
                    <td><c:out value="${b.borrowerLastName} ${b.borrowerFirstName}" /> </td>
                    <td> <a href="books/${b.ident}/edit">edit</a></td>
                    <td> <a href="books/${b.ident}/delete">delete</a></td>
                </tr>
                </c:forEach>
            </table>


</body>
</html>