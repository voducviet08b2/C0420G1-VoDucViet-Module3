<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 8/3/2020
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm mới</title>
</head>
<body>
<form action="/products?action=a" method="post">
    <lable>Id sản phẩm</lable>
    <input type="text" name="id"><br>
    <lable>Tên sản phẩm</lable>
    <input type="text" name="name"><br>
    <lable>Mô tả sản phẩm</lable>
    <input type="text" name="description"><br>
    <lable>Giá sản phẩm</lable>
    <input type="text" name="price"><br>
    <input type="submit">
</form>
</body>
</html>
