<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 07.06.17
  Time: 08:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Address page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Address page</h1>
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

    <a href="newAddressForm">New address</a> |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Postal Code</th>
            <th>City</th>
            <th>Street</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${addressList}" var="address">
            <tr>
                <td>${address.id}</td>
                <td>${address.postalCode}</td>
                <td>${address.city}</td>
                <td>${address.street}</td>
                <td>${address.country}</td>
                <td>
                    <c:url var="updateAddress" value="/customer/updateAddressForm"/>
                    <form id="${address.id}" action="${updateAddress}" method="POST">
                        <input id="addressUpdate" name="addressId" type="hidden" value="${address.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <c:url var="deleteAddress" value="/customer/deleteAddress"/>
                    <form id="${address.id}" action="${deleteAddress}" method="POST">
                        <input id="addresDelete" name="addressId" type="hidden" value="${address.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Deleting address [${address.id}]. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
