<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
    <form action="/studentServletPath" method="post">
        <input type="hidden" name="actionName" value="${actionName}" />
        <input type="hidden" name="id" value="${student.id}" />
        <label for="nameStudent">Name: </label>
        <input id="nameStudent" type="text" name="nameStudent" value="${student.name}"/><br>
        <label for="dateOfBirth">Date of birth: </label>
        <input id="dateOfBirth" type="text" name="dateOfBirth" value="${student.dateOfBirth}"/><br>
        <input type="submit" value="Save" />
    </form>
</body>
</html>
