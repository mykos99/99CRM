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
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Actions page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Actions page</h1>
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

    <a href="/action/actionUpdateFormStart">New Action</a> |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Customer</th>
            <th>Contact</th>
            <th>Email</th>
            <th>Tel</th>
            <th>From User</th>
            <th>To User</th>
            <th>Action Type</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${actionList}" var="action">
            <tr>
                <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${action.startDate}"/></td>
                <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm" value = "${action.endDate}"/></td>
                        <td>${action.customer.shortName}</td>
                        <td>${action.contact.firstName} ${action.contact.lastName}</td>
                        <td>${action.contact.email}</td>
                        <td>${action.contact.telephone}</td>
                        <td>${action.fromUser.firstName} ${action.fromUser.lastName}</td>
                        <td>${action.toUser.firstName} ${action.toUser.lastName}</td>
                        <td>${action.actionType.name}</td>
                <td>
                    <c:url var="updateAction" value="/action/updateAction"/>
                    <form id="${action.id}" action="${updateAction}" method="POST">
                        <input id="actionId" name="actionId" type="hidden" value="${action.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <c:url var="deleteAction" value="/action/deleteAction"/>
                    <form id="${action.id}" action="${deleteAction}" method="POST">
                        <input id="actionDelete" name="actionId" type="hidden" value="${action.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Deleting Action! Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
