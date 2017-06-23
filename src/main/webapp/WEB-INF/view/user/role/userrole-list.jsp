<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 07.06.17
  Time: 05:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Type page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Employee Type page</h1>
    <p>Choose one of the options below:</p>

    <a href="newEmployeeTypeForm">New employeeType</a> |
    <a href="/employee/list">Employees</a> |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeTypeList}" var="employeeType">
            <tr>
                <td>${employeeType.id}</td>
                <td>${employeeType.name}</td>
                <td>
                    <c:url var="updateEmployeeType" value="/employee/updateEmployeeTypeForm"/>
                    <form id="${employeeType.id}" action="${updateEmployeeType}" method="POST">
                        <input id="empTypeIdUpdate" name="empTypeId" type="hidden" value="${employeeType.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <c:url var="deleteEmployeeType" value="/employee/deleteEmployeeType"/>
                    <form id="${employeeType.id}" action="${deleteEmployeeType}" method="POST">
                        <input id="empTypeIdDelete" name="empTypeId" type="hidden" value="${employeeType.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Removing employee type [${employeeType.id}] ${employeeType.name}. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
