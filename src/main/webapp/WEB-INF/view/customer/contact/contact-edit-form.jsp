<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 08.06.17
  Time: 07:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact edit form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Contact edit form</h1>
    <p>Please put below contact details and click SAVE to update database:</p>
    <c:set var="action" value="newContactProcess"/>
    <c:if test="${update}">
        <c:set var="action" value="updateContactProcess"/>
    </c:if>
    <form:form method="POST"  action="${action}" modelAttribute="contact">
        <form:input path="id" type="hidden" value="${contact.id}"/>
        <table class="table table-striped">
            <tbody>
                <tr>
                    <td align="right">First Name</td>
                    <td><form:input path="firstName" value="${contact.firstName}"/></td>
                </tr>
                <tr>
                    <td align="right">Last Name</td>
                    <td><form:input path="lastName" value="${contact.lastName}"/></td>
                </tr>
                <tr>
                    <td align="right">Position</td>
                    <td><form:input path="position" value="${contact.position}"/></td>
                </tr>
                <tr>
                    <td align="right">Telephone</td>
                    <td><form:input path="telephone" value="${contact.telephone}"/></td>
                </tr>
                <tr>
                    <td align="right">Email</td>
                    <td><form:input path="email" value="${contact.email}"/></td>
                </tr>
                <tr>
                    <td align="right">Customer</td>
                    <td><form:select path="customer.id" items="${customers}" itemValue="id" value="${contact.customer}"/></td>
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
