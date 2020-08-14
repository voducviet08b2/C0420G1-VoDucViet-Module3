<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body><br>
<a href="/noteServlet?action=create" class="btn btn-primary">Tạo note mới</a><br>
<br>
<form action="/noteServlet">
    <input type="text" placeholder="Nhập từ khóa" name="k">
    <input  type="hidden" name="action" value="search">
    <input class="btn btn-primary" type="submit" value="Tìm kiếm">
</form>
<br>
<a class="btn btn-secondary" href="/noteServlet?action=order"> Sắp xếp theo tên </a>
<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Tiêu đề</th>
        <th scope="col">Nội dung</th>
        <th scope="col">Phân loại</th>
        <th scope="col">Chỉnh Sửa</th>
        <th scope="col">Xóa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="note" items="${noteList}">
    <tr>
        <th scope="row"><c:out value="${note.id}"></c:out></th>
        <td><a href="/noteServlet?action=detailView&id=${note.id}"><c:out value="${note.title}"></c:out></a></td>
        <td><c:out value="${note.content}"></c:out></td>
        <c:forEach var="noteType" items="${noteTypeList}">
            <c:if test="${note.typeId==noteType.id}">
                <td><c:out value="${noteType.name}"></c:out></td>
            </c:if>
        </c:forEach>
        <td><a class="btn btn-secondary" href="/noteServlet?action=update&id=${note.id}">Chỉnh Sửa</a></td>
        <td><a class="btn btn-danger" href="/noteServlet?action=delete&id=${note.id}">Xóa</a></td>
    </tr>
    </c:forEach>
    <ul style="list-style: none;display: flex">
        <c:forEach begin="1" end="${totalPage}" var="val">
            <li><a href="/noteServlet?page=${val}"><c:out value="${val}"/></a></li>
        </c:forEach>
    </ul>

    </tbody>
</table>

</body>
</html>
