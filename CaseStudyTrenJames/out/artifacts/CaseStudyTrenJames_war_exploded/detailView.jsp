<%@ page import="model.Note" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="note" items="${noteList}">
    <label for="">Tiêu đề: </label>
<p> <c:out value="${note.title}"></c:out></p>
    <label for="">Nội dung: </label>
<p> <c:out value="${note.content}"></c:out></p>
</c:forEach>

</body>
</html>
