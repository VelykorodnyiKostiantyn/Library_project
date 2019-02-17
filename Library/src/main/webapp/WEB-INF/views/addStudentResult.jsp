<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file = "../include/header.jsp" %>
<body>
    <h2>Submitted Employee Information</h2>
    <table>
        <tr>
            <td>First Name :</td>
            <td>${firstName}</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${contactNumber}</td>
        </tr>
    </table>


</body>
</html>