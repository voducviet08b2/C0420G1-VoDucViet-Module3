<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/26/2020
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>showCustomerList</title>
</head>
<style>
    h2 {

    }
    table{
        font-size: 30px;
        text-align: left;
        border-collapse: collapse;
        width: 50%;
        box-shadow: burlywood;
    }
    table,th,td{
        border: 1px solid black;

    }
    th, td{
        height: 50%;
        padding: 8px;
    }
    tr:nth-child(even){
        background-color: aliceblue;
    }

    th{
        background-color: blue;
        color: white;
    }

</style>
<body>
<%--    <% List<Customer> customerList2 = (List<Customer>) request.getAttribute("listCustomer");%>--%>

    <table >
        <tr>
            <td style="text-align: center; font-size: larger; border-top: hidden; border-left: hidden; border-right: hidden" colspan="4">
                <h2>
                    List of Customers
                </h2>
            </td>

        </tr>

        <tr>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>Image</th>
        </tr>
        <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td><c:out value="${customer.name}"></c:out></td>
            <td><c:out value="${customer.birthday}"></c:out></td>
            <td><c:out value="${customer.address}"></c:out></td>
            <td><img width="150px" height="150px" src="${customer.imageURL}"/></td>

        </tr>
        </c:forEach>
    </table>


</body>
</html>
