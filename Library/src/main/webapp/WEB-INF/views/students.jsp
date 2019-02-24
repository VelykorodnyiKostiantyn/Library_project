<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="include/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
        <form:form method="POST"
          action="students" modelAttribute="student">
             <table>
                <tr>
                    <td><form:label path="firstName">First name</form:label></td>
					<td><form:label path="lastName">Last name</form:label></td>
					<td><form:label path="email">Email</form:label></td>
                </tr>
                <tr>
                    <td><form:input path="firstName"/></td>
                    <td><form:input path="lastName"/></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="search"/></td>
                </tr>
            </table>
        </form:form>
            <table>
                <tr>
                <td>ident</td>
                    <td>First name</td>
					<td>Last name</td>
					<td>Email</td>
                </tr>
                <c:forEach var="s" items="${students}">
                <tr>
                	<td><c:out value="${s.ident}"></c:out></td>
                    <td><c:out value="${s.firstName}" /> </td>
                    <td><c:out value="${s.lastName}" /> </td>
                    <td><c:out value="${s.email}" /> </td>
                    <td> <a href="students/${s.ident}/edit">edit</a></td>
                    <td> <a href="students/${s.ident}/delete">delete</a></td>
                    <td> <a href="students/${s.ident}/manage_books">manage books</a></td>
                </tr>
                </c:forEach>
            </table>


</body>
</html>