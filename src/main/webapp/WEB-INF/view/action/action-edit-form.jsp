<%--
  Created by IntelliJ IDEA.
  User: mikolaj
  Date: 19.06.17
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New Action form - details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.4/jquery.datetimepicker.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.4/build/jquery.datetimepicker.full.min.js"></script>
    <%--Date Time Picker script--%>
    <script type="text/javascript">
        $(function () {
            $('#dtpStartDate').datetimepicker();
            $('#dtpEndDate').datetimepicker();
        });
    </script>

</head>
<body>

<div class="container">
    <h1>New Action form - details</h1>
    <table class="table table-striped">
        <tbody>
        <tr>
            <td align="right">Customer</td>
            <td>
                <form:form method="POST" action="/action/newActionFormCustomer">
                    <input type="text" value="${action.customer.shortName}"/>
                    <input type="submit" value="Select"/>
                </form:form>
            </td>
        </tr>
        <tr>
            <td align="right">Contact</td>
            <td>
                <form:form method="POST" action="/action/newActionFormContact">
                    <input type="text" value="${action.contact.firstName} ${action.contact.lastName}"/>
                    <c:if test="${action.customer.id>0}">
                        <input id="customer" name="customerId" type="hidden" value="${action.customer.id}"/>
                        <input type="submit" value="Select"/>
                    </c:if>
                </form:form>
            </td>
        </tr>
        <form:form method="POST" action="newActionProcess" modelAttribute="action">
            <form:input path="customer.id" type="hidden" value="${action.customer.id}"/>
            <form:input path="contact.id" type="hidden" value="${action.contact.id}"/>
            <tr>
                <td align="right">From User</td>
                <td><form:select path="fromUser.id" items="${userList}" itemValue="id"
                                 selectedValue="${action.fromUser.id}"/></td>
            </tr>
            <tr>
                <td align="right">To User</td>
                <td><form:select path="toUser.id" items="${userList}" itemValue="id"
                                 selectedValue="${action.toUser.id}"/></td>
            </tr>

            <tr>
                <td align="right">Description</td>
                <td><form:input path="description" value="${action.description}"/></td>
            </tr>
            <tr>
                <td align="right">Start time</td>
                <td>
                    <form:input path="startDate" id="dtpStartDate"/>
                </td>
            </tr>
            <tr>
                <td align="right">End time</td>
                <td>
                    <form:input path="endDate" id="dtpEndDate"/>
                </td>
            </tr>
            <tr>
                <td align="right">Action Type</td>
                <td><form:select path="actionType.id" items="${actionTypeList}" itemValue="id"
                                 value="${action.actionType}"/></td>
            </tr>
            <tr>
                <td align="right"><input type="submit" value="Save"/></td>
            </tr>
        </form:form>
        </tbody>
    </table>
</div>

</body>
</html>
