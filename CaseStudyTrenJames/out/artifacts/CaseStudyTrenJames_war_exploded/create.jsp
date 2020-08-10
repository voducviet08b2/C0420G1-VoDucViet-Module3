<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tạo note mới</h1>
<form action="/noteServlet" method="get">
    <input type="hidden" name="action" value="updateCreate">
    <label for="">Tên Note</label>
    <input type="text" name="title">
    <br>
    <label for="">Nội dung</label>
    <input type="text" name="content">
    <br>
    <label for="">Phân loại</label>
    <select name="typeId">
        <c:forEach var="typeId" items="${noteTypeList}">
            <option value="${typeId.id}" ><c:out value="${typeId.name}"></c:out></option>
        </c:forEach>
    </select>

    <input type="submit" value="Tạo mới">
</form>
</body>
</html>
