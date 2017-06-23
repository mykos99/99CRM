<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 07.06.17
  Time: 05:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new Employee Type</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Employee Type form</h1>
    <p>Please put below employee type details and click SAVE to update database:</p>
    <c:set var="action" value="newEmployeeTypeProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateEmployeeTypeProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="employeeType">
        <form:input path="id" type="hidden" value="${employeeType.id}"/>
        Name: <form:input path="name" value="${employeeType.name}"/>
        <br>
        <input type="submit" value="Save" />
    </form:form>
</div>
</body>
</html>
