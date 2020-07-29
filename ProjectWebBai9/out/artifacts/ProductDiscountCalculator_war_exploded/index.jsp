<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 7/24/2020
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product</title>
  </head>
  <body>
  <form action="/discountServlet" method="get">
    <label for="">Product Description</label>
    <input type="text" name="description" placeholder="Mô tả sản phẩm">
    <label for="">List Price</label>
    <input type="text" name="price"  placeholder="Giá">
    <label for="">Discount</label>
    <input type="text" name="discount" placeholder="Giảm giá">
    <input type="submit" value="Result">
  </form>
  </body>
</html>
