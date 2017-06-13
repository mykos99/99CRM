<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 07.06.17
  Time: 08:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Address form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Address form</h1>
    <p>Please put below address details and click SAVE to update database:</p>
    <c:set var="action" value="newAddressProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateAddressProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="address">
        <form:input path="id" type="hidden" value="${address.id}"/>
        Postal Code: <form:input path="postalCode" value="${address.postalCode}"/>
        <br>
        City: <form:input path="city" value="${address.city}"/>
        <br>
        Street: <form:input path="street" value="${address.street}"/>
        <br>
        Country: <form:input path="country" value="${address.country}"/>
        <br>
        <input type="submit" value="Save" />
    </form:form>
</div>
</body>
</html>