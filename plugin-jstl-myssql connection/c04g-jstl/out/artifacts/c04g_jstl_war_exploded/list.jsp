<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 07/24/2020
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Type</th>
        </tr>
<%--        <%--%>
<%--            List<Student> studentList = (List<Student>) request.getAttribute("studentListServlet");--%>
<%--            for (Student student: studentList) {--%>
<%--        %>--%>
<%--            <tr>--%>
<%--                <td><%=student.getId()%></td>--%>
<%--                <td><%=student.getName()%></td>--%>
<%--                <td><%=student.getDateOfBirth()%></td>--%>
<%--            </tr>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
        <c:forEach var="student" items="${studentListServlet}">
            <tr>
                <td><c:out value="${student.id}"></c:out></td>
                <td><c:out value="${student.name}"></c:out></td>
                <td><c:out value="${student.dateOfBirth}"></c:out></td>
                <td>
                    <c:choose>
                        <c:when test="${student.mark > 8}">
                            Very Good
                        </c:when>
                        <c:when test="${student.mark < 8 && student.mark > 5}">
                            Good
                        </c:when>
                        <c:when test="${student.mark < 5}">
                            Poor
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:out value="${inputUser}"></c:out>
    ${inputUser}
</body>
</html>
