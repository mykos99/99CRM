<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 07.06.17
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Customers page</h1>
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

    <a href="/customer/newCustomerForm">New customer</a> |
    <a href="/customer/customerTypeList">CustomerTypes</a> |
    <a href="/">Main Page</a>

    <table class="table">
        <thead>
        <tr>
            <th>Short Name</th>
            <th>Long Name</th>
            <th>Email</th>
            <th>Tel</th>
            <th>VAT</th>
            <th>Regon</th>
            <th>Address</th>
            <th>Salesman</th>
            <th>Customer type</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>[${customer.id}] ${customer.shortName}</td>
                <td>${customer.longName}</td>
                <td>${customer.email}</td>
                <td>${customer.telephone}</td>
                <td>${customer.vat}</td>
                <td>${customer.regon}</td>
                <td>${customer.address.city} ${customer.address.postalCode}, ${customer.address.street}</td>
                <td>[${customer.salesman.id}] ${customer.salesman.firstName} ${customer.salesman.lastName}</td>
                <td>${customer.custType.name}</td>
                <td>
                    <c:url var="customerContacts" value="/customer/customerContactList"/>
                    <form id="${customer.id}" action="${customerContacts}" method="POST">
                        <input id="customerContactsList" name="customerId" type="hidden" value="${customer.id}"/>
                        <input type="submit" value="Contacts" />
                    </form>
                    <c:url var="updateCustomer" value="/customer/updateCustomerForm"/>
                    <form id="${customer.id}" action="${updateCustomer}" method="POST">
                        <input id="customerId" name="customerId" type="hidden" value="${customer.id}"/>
                        <input type="submit" value="Update"/>
                    </form>
                    <c:url var="deleteCustomer" value="/customer/deleteCustomer"/>
                    <form id="${customer.id}" action="${deleteCustomer}" method="POST">
                        <input id="customerDelete" name="customerId" type="hidden" value="${customer.id}"/>
                        <input type="submit" value="Delete"
                               onClick="return confirm('Deleting customer [${customer.id}] ${customer.shortName}. Are you sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
