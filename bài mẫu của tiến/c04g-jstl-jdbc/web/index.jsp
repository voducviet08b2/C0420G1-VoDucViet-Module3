<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello World!
<%--  <script>--%>
<%--    location.href = '/studentServletPath';--%>
<%--  </script>--%>
<%--  <a href="/studentServletPath">Go student list</a>--%>
  <c:redirect url="/studentServletPath"></c:redirect>
  </body>
</html>
