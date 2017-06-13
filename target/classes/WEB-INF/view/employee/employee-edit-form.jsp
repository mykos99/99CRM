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
    <title>Add new employee</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Employee form</h1>
    <p>Please put below employee details and click SAVE to update database:</p>
    <c:set var="action" value="newEmployeeProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateEmployeeProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="employee">
        <form:input path="id" type="hidden" value="${employee.id}"/>
        First name: <form:input path="firstName" value="${employee.firstName}"/>
        <br>
        Last name: <form:input path="lastName" value="${employee.lastName}"/>
        <br>
        Position: <form:input path="position" value="${employee.position}"/>
        <br>
        Email: <form:input path="email" value="${employee.email}"/>
        <br>
        Telephone: <form:input path="telephone" value="${employee.telephone}"/>
        <br>
        Employee Type:
        <form:select path="empType.id" items="${employeeTypeList}"  itemValue="id" value="${employee.empType}"/>
        <br>
        <input type="submit" value="Save" />
    </form:form>

</div>

</body>
</html>
