<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 8/4/2020
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Danh sách User</h3><br>
<a href="create.jsp">Tạo người dùng mới</a><br>
<table border="1" style="border-collapse: collapse">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
<c:forEach var="user" items="${listUser}">
    <tr>
        <td><c:out value="${user.id}"></c:out></td>
        <td><c:out value="${user.name}"></c:out></td>
        <td><c:out value="${user.email}"></c:out></td>
        <td><c:out value="${user.country}"></c:out></td>
        <td><a href="/userservlet?action=edit&id=<c:out value="${user.id}"></c:out>">Edit</a></td>
        <td>Delete</td>
    </tr>
</c:forEach>

</table>
</body>
</html>
