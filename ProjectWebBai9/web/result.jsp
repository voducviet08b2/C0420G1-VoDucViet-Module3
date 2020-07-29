<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 7/24/2020
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Giá: <%=request.getAttribute("priceServlet")%></p>
<p>Giảm giá: <%=request.getAttribute("discountServlet")%></p>
<p>Mô tả sản phẩm: <%=request.getAttribute("desServlet")%></p>
<h1>
    <%=request.getAttribute("resultServlet")%>
</h1>

</body>
</html>
