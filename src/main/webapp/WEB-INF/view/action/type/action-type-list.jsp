<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 18.06.17
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Action Type page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Action Type page</h1>
    <p>Choose one of the options below:</p>
    <%--ALERTS--%>
    <%--<div class="alert alert-success alert-dismissable">--%>
    <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>--%>
    <%--<strong>Success!</strong> This alert box could indicate a successful or positive action.--%>
    <%--</div>--%>
    <%--<div class="alert alert-info alert-dismissable">--%>
    <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>--%>
    <%--<strong>Info!</strong> This alert box could indicate a neutral informative change or action.--%>
    <%--</div>--%>
    <%--<div class="alert alert-warning alert-dismissable">--%>
    <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>--%>
    <%--<strong>Warning!</strong> This alert box could indicate a warning that might need attention.--%>
    <%--</div>--%>
    <%--<div class="alert alert-danger alert-dismissable">--%>
    <%--<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>--%>
    <%--<strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.--%>
    <%--</div>--%>
    <a href="/action/newActionTypeForm">New Action type</a>   |
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
        <c:forEach items="${actionTypeList}" var="actionType">
            <tr>
                <td>${actionType.id}</td>
                <td>${actionType.name}</td>
                <td>
                    <%--Update button--%>
                    <c:url var="updateActionType" value="/action/updateActionTypeForm"/>
                    <form id="${actionType.id}" action="${updateActionType}" method="POST">
                        <input id="actionTypeUpdate" name="actionTypeId" type="hidden" value="${actionType.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <%--Delete button--%>
                    <c:url var="deleteActionButton" value="/action/deleteActionType"/>
                    <form id="${actionType.id}" action="${deleteActionButton}" method="POST">
                        <input id="actionTypeDelete" name="actionTypeId" type="hidden" value="${actionType.id}"/>
                        <input type="submit" value="Delete"
                               onclick="return confirm('Deleting ActionType [${actionType.id}] ${actionType.name}. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>


</body>
</html>
