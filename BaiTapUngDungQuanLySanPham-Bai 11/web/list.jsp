<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Danh mục sản phẩm</h1>

<a href="/products?action=create">Thêm sản phẩm mới</a>
<table border="1">

    <tr>
        <td>Id sản phẩm</td>
        <td>Tên sản phẩm</td>
        <td>Mô tả sản phẩm</td>
        <td>Giá tiền</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"></c:out></td>
            <td><c:out value="${product.name}"></c:out></td>
            <td><c:out value="${product.description}"></c:out></td>
            <td><c:out value="${product.price}"></c:out></td>
            <td><a href="/products?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
