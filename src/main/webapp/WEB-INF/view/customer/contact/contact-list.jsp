<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 08.06.17
  Time: 07:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <c:choose>
        <c:when test="${customer.id>0}">
            <h1>Contact page - ${customer.shortName}</h1></c:when>
        <c:otherwise>
          <h1>Contact page</h1>
        </c:otherwise>
    </c:choose>
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

    <a href="/customer/newContactForm">New contact</a> |
    <a href="/customer/list">Customers</a> |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Position</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Customer</th>
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
                <td>[${contact.customer.id}] ${contact.customer.shortName}</td>
                <td>
                    <%--Update button--%>
                    <c:url var="updateContact" value="/customer/updateContactForm"/>
                    <form id="${contact.id}" action="${updateContact}" method="POST">
                        <input id="contactId" name="contactId" type="hidden" value="${contact.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <%--Delete button--%>
                    <c:url var="deleteContact" value="/customer/deleteContact"/>
                    <form id="${contact.id}" action="${deleteContact}" method="POST">
                        <input id="contactDelete" name="contactId" type="hidden" value="${contact.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Deleting contact [${contact.id}] ${contact.firstName} ${contact.lastName}. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
