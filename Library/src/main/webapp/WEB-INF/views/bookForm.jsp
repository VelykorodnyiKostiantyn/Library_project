<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file = "include/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding student</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

        <h3>Enter The Student Details</h3>
        <form:form method="POST"
          action="${action}" modelAttribute="book">
          <form:hidden path="ident"/>
             <table>
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title"/></td>
                    <td><form:errors path="title" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><form:label path="author">Author</form:label></td>
                    <td><form:input path="author"/></td>
                    <td><form:errors path="author" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><input type="submit" value="done"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>