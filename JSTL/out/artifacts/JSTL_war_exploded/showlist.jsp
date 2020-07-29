

<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
    </tr>


<% List<Student> studentList=(List<Student>)request.getAttribute("listStudent");
    for (int i = 0; i < studentList.size(); i++) {
%>
    <tr>
        <td><%=studentList.get(i).getId()%></td>
        <td><%=studentList.get(i).getName()%></td>
        <td><%=studentList.get(i).getDateOfBirth()%></td>
      <td><%=studentList.get(i).getTitleHTML()%></td>
    </tr>

<%}%>
</table>

<table border="1" style="border-collapse: collapse">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
    </tr>

</table>

</body>
</html>
