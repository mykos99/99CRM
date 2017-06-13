<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 08.06.17
  Time: 07:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Type page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Customer Type page</h1>
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

    <a href="newCustomerTypeForm">New customer type</a> |
    <a href="/customer/list">Customers</a>  |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerTypeList}" var="customerType">
            <tr>
                <td>${customerType.id}</td>
                <td>${customerType.name}</td>

                <td>
                    <c:url var="updateCustomerType" value="/customer/updateCustomerTypeForm"/>
                    <form id="${customerType.id}" action="${updateCustomerType}" method="POST">
                        <input id="updateCustomerType" name="customerTypeId" type="hidden" value="${customerType.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <c:url var="deleteCustomerType" value="/customer/deleteCustomerType"/>
                    <form id="${customerType.id}" action="${deleteCustomerType}" method="POST">
                        <input id="customerTypeDelete" name="customerTypeId" type="hidden" value="${customerType.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Deleting customer type [${customerType.id}] ${customerType.name}. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
