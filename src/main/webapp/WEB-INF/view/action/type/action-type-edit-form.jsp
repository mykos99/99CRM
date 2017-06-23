<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 18.06.17
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ActionType edit form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>ActionType edit form</h1>
    <p>Please put below ActionType details and click SAVE to update database:</p>
    <c:set var="action" value="newActionTypeProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateActionTypeProcess"/>
    </c:if>
    <form:form method="POST" action="${action}" modelAttribute="actionType">
        <form:input path="id" type="hidden" value="${actionType.id}"/>
        <table class="table table-striped">
            <tbody>
            <tr>
                <td align="right">Name</td>
                <td><form:input path="name" value="${actionType.name}"/></td>
            </tr>
            <tr>
                <td align="right"><input type="submit" value="Save" /></td>
            </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
