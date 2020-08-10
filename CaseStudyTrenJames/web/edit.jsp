<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/noteServlet" method="get">
    <input type="hidden" name="action" value="confirmUpdate">
    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">
    <label for="">Tên Note</label>
    <input type="text" name="title" value="<%=request.getAttribute("title")%>">
    <br>
    <label for="">Nội dung</label>
    <input type="text" name="content" value="<%=request.getAttribute("content")%>">
    <br>

    <label for="">Phân loại</label>

    <select name="typeId">
        <c:forEach var="typeId" items="${noteTypeList}">
            <c:choose>
            <c:when test="${nameType.equals(typeId.name)}">
                <option selected value="${typeId.id}" ><c:out value="${typeId.name}"></c:out></option>
            </c:when>
                <c:otherwise>
                    <option value="${typeId.id}" ><c:out value="${typeId.name}"></c:out></option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>

    <input type="submit" value="Chỉnh sửa thông tin">
</form>
</body>
</html>
