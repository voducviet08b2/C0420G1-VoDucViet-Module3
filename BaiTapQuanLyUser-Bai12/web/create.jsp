<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 8/4/2020
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Tạo mới user </h1>
<form action="/userservlet" method="get">
    <input type="hidden" name="action" value="create">
    <label for="">Tên người dùng</label>
    <input type="text" name="name"><br>
    <label for="">Email</label>
    <input type="text" name="email"><br>
    <label for="">Country</label>
    <input type="text" name="country"><br>
    <input type="submit" value="Tạo người dùng mới">
</form>
</body>
</html>
