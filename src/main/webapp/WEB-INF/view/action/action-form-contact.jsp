<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 19.06.17
  Time: 07:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Action form - choose Contact</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>New Action form - select Contact</h1>
    <h2>${action.customer.shortName}</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Position</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contactList}" var="contact">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.firstName} ${contact.lastName}</td>
                <td>${contact.position}</td>
                <td>${contact.telephone}</td>
                <td>${contact.email}</td>
                <td>
                    <c:url var="selectContact" value="/action/contactSelected"/>
                    <form id="${contact.id}" action="${selectContact}" method="POST">
                        <form:input path="action.customer.id" type="hidden" value="${action.customer.id}"/>
                        <input id="contactId" name="contactId" type="hidden" value="${contact.id}"/>

                        <input type="submit" value="Select"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
