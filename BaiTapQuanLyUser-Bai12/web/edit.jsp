<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Sửa user </h1>
<form action="/userservlet" method="get">
    <input type="hidden" name="action" value="confirmupdate">
    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
    <label for="">Tên người dùng</label>
    <input type="text" name="name" value="<%=request.getAttribute("name")%>"><br>
    <label for="">Email</label>
    <input type="text" name="email" value="<%=request.getAttribute("email")%>"><br>
    <label for="">Country</label>
    <input type="text" name="country" value="<%=request.getAttribute("country")%>"><br>
    <input type="submit" value="Xác nhận sửa thông tin người dùng">
</form>
</body>
</html>
