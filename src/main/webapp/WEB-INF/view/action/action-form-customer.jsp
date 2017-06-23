<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 19.06.17
  Time: 07:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Action form - select Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>New Action form - select customer</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Short Name</th>
            <th>Long Name</th>
            <th>VAT</th>
            <th>Address</th>
            <th>Salesman</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>[${customer.id}] ${customer.shortName}</td>
                <td>${customer.longName}</td>
                <td>${customer.vat}</td>
                <td>${customer.address.city} ${customer.address.postalCode}, ${customer.address.street}</td>
                <td>[${customer.salesman.id}] ${customer.salesman.firstName} ${customer.salesman.lastName}</td>
                <td>
                    <c:url var="selectCustomer" value="/action/customerSelected"/>
                    <form id="${customer.id}" action="${selectCustomer}" method="POST">
                        <input id="customerId" name="customerId" type="hidden" value="${customer.id}"/>
                        <input type="submit" value="Select" />
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
