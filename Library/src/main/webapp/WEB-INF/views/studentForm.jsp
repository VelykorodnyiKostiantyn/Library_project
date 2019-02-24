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
          action="${action}" modelAttribute="student">
          <form:hidden path="ident"/>
             <table>
                <tr>
                    <td><form:label path="firstName">First name</form:label></td>
                    <td><form:input path="firstName"/></td>
                    <td><form:errors path="firstName" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last name</form:label></td>
                    <td><form:input path="lastName"/></td>
                    <td><form:errors path="lastName" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><input type="submit" value="done"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>