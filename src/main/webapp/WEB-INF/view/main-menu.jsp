<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Main Page</h1>
    <p>Choose one of the options below:</p>

    <a href="/employee/list">Employees</a>  |
    <a href="/customer/list">Customers</a>  |
    <a href="/customer/contactList">Contacts</a>  |
    <a href="/customer/addressList">Addresses</a>  |
    <a href="/customer/customerTypeList">Customer Types</a>

</div>
</body>
</html>
