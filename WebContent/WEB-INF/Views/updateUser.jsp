<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.springmvc.contAppSpring.models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit user</title>
</head>
<body> 
<% User user = (User) request.getAttribute("user"); %>
<form action="${pageContext.request.contextPath}/saveUser" method="post">
    <input name="id" id="userId" hidden="true" value="${user.getId()}">
    <label for="username">Username</label>
    <input name="username" id="username" type="text" value="${user.getUsername()}">
    <label for="password">Password</label>
    <input name="password" id="password" type="text" value="${user.getPassword()}">
    <label for="email">Email</label>
    <input name="email" id="email" type="text" value="${user.getEmail()}">
    <label for="role">Role</label>
    <input name="role" id="role" type="text" value="${user.getRole()}">
    <label for="firmId">Firm ID</label>
    <input name="firmId" id="firmId" type="text" value="${user.getFirmId()}">
    <button name="submitUserUpdate" type="submit" formmethod="post">Update</button>
</form>
</body>
</html>

</body>
</html>