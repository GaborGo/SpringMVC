<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.springmvc.contAppSpring.models.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Users</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        table {
            margin-left: auto;
            margin-right: auto;
            width: 80%;
        }
    </style>
</head>
<body>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Role</th>
        <th>Firm Id</th>
        <th>Action</th>
        <c:forEach items="${users}" var="user">
    </tr>
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getUsername()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getRole()}</td>
        <td>${user.getFirmId()}</td>

        
            <td style="align-content: center">
                <form action="${pageContext.request.contextPath}/deleteUser" method="post">
                    <button action="${pageContext.request.contextPath}/deleteUser" name="delete" formmethod="delete" type="submit" value="${user.getId()}">Delete</button>
                </form>
                <form action="${pageContext.request.contextPath}/updateUser" method="post">
                    <button action="${pageContext.request.contextPath}/deleteUser" name="update" formmethod="update" type="submit" value="${user.getId()}">Update</button>
                </form>
            </td>
        

    </tr>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/" modelAttribute="newUser" method="post">
        <tr>
            <td><input type="number" name="id" id="id" size="10" required></td>
            <td><input name="username" id="username" type="text" size="10" required></td>
            <td><input name="password" id="password" type="text" size="10" required></td>
            <td><input name="email" id="email" type="text" size="10" required></td>
            <td><input name="role" id="role" type="text" size="10" required></td>
            <td><input name="firmId" id="firmId" type="number" size="4" required></td>
            <td>
                <button name="submitUserUpdate" type="submit" formmethod="post">Add user</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>