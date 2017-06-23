<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 01.06.17
  Time: 07:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>User form</h1>
    <p>Please put below user details and click SAVE to update database:</p>
    <c:set var="action" value="newUserProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateUserProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="user">
        <form:input path="id" type="hidden" value="${user.id}"/>
        First name: <form:input path="firstName" value="${user.firstName}"/>
        <br>
        Last name: <form:input path="lastName" value="${user.lastName}"/>
        <br>
        Position: <form:input path="position" value="${user.position}"/>
        <br>
        Email: <form:input path="email" value="${user.email}"/>
        <br>
        Telephone: <form:input path="telephone" value="${user.telephone}"/>
        <br>
        User role:
        <form:select path="userRole.id" items="${userRoleList}" itemValue="id" value="${user.userRole}"/>
        <br>
        <input type="submit" value="Save" />
    </form:form>

</div>

</body>
</html>
