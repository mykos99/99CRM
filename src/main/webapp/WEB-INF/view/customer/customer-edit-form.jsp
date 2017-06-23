<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 08.06.17
  Time: 07:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer edit form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Customer edit form</h1>
    <p>Please put below customer details and click SAVE to update database:</p>
    <c:set var="action" value="newCustomerProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateCustomerProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="customer">
        <form:input path="id" type="hidden" value="${customer.id}"/>
        <form:input path="address.id" type="hidden" value="${customer.address.id}"/>
        Short name: <form:input path="shortName" value="${customer.shortName}"/><br>
        Long name: <form:input path="longName" value="${customer.longName}"/><br>
        City: <form:input path="address.city" value="${customer.address.city}"/><br>
        PostalCode: <form:input path="address.postalCode" value="${customer.address.postalCode}"/><br>
        Address: <form:input path="address.street" value="${customer.address.street}"/><br>
        Country: <form:input path="address.country" value="${customer.address.country}"/><br>
        Email: <form:input path="email" value="${customer.email}"/><br>
        Telephone: <form:input path="telephone" value="${customer.telephone}"/><br>
        Fax: <form:input path="fax" value="${customer.fax}"/><br>
        VAT: <form:input path="vat" value="${customer.vat}"/><br>
        Regon: <form:input path="regon" value="${customer.regon}"/><br>
        Salesman: <form:select path="salesman.id" items="${userList}"  itemValue="id" value="${customer.salesman}"/><br>
        Customer Type: <form:select path="custType.id" items="${customerTypeList}"  itemValue="id" value="${customer.custType}"/><br>
        <input type="submit" value="Save" />
    </form:form>
</div>
</body>
</html>
