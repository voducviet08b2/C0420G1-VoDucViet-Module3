<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <%--    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(function () {
            var pageSize = 6; // Hiển thị 6 sản phẩm trên 1 trang
            showPage = function (page) {
                $(".contentPage").hide();
                $(".contentPage").each(function (n) {
                    if (n >= pageSize * (page - 1) && n < pageSize * page)
                        $(this).show();
                });
            }
            showPage(1);
            ///** Cần truyền giá trị vào đây **///
            var totalRows = ${count}; // Tổng số sản phẩm hiển thị
            var btnPage = 5; // Số nút bấm hiển thị di chuyển trang
            var iTotalPages = Math.ceil(totalRows / pageSize);

            var obj = $('#pagination').twbsPagination({
                totalPages: iTotalPages,
                visiblePages: btnPage,
                onPageClick: function (event, page) {
                    console.info(page);
                    showPage(page);
                }
            });
            console.info(obj.data());
        });
    </script>
</head>

<body>
<div class="header" >
    <div class="container pt-2">
        <div class="row">
            <div class="col-3">
                <img src="https://upload.wikimedia.org/wikipedia/vi/archive/d/dc/20200125142348%21Vinfast-logo.png" alt="" width="60pxpx" height="60px">
            </div>
            <div class="col-3"></div>
            <div class="col-3"></div>
            <div class="col-3">
                <h2>Võ Đức Việt</h2>
            </div>
        </div>
    </div>
</div>
<br><br>
<div class="menu" style="background-color: blanchedalmond;">
    <div class="container">
        <div class="row" style="display:flex;align-items: center;">
            <div class="col-2">
                <a href="">Home</a>
            </div>
            <div class="col-2">
                <a href="/employeeServlet">Employee</a>
            </div>
            <div class="col-2">
                <a href="">Customer</a>
            </div>
            <div class="col-2">
                <a href="/serviceServlet">Service</a>
            </div>
            <div class="col-2">
                <a href="">Contact</a>
            </div>
            <div class="col-2">
                <form action="/employeeServlet" method="get" style="display: flex;margin-top: 15px">
                    <input type="hidden" name="action" value="search">
                    <input type="text" class="form-control" name="keyword" placeholder=" Your Text">
                    <input type="submit" value="Search">
                </form>
            </div>

        </div>
    </div>
</div>
<br><br>
<div class="content" >
    <div class="container">
        <div class="row">
            <div class="col-1" style="display: flex;flex-direction: column;justify-content: flex-start;align-items: flex-start;background-color: rgb(231, 231, 231)">
                <a class="btn btn-primary" href="/employeeServlet?action=create">Create</a>
                <br>
                <a class="btn btn-info" href="btn btn-info">Show</a>
            </div>
            <div class="col-11">da
                <table class="table table-striped" >
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Họ tên</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">Số CMND</th>
                        <th scope="col">Lương</th>
                        <th scope="col">Số Điện thoại</th>
                        <th scope="col">Email</th>
                        <th scope="col">Địa chỉ</th>
                        <th scope="col">Vị trí</th>
                        <th scope="col">Trình độ</th>
                        <th scope="col">Bộ phận</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${employeeList}">


                        <tr class="contentPage">
                            <th scope="row"><c:out value="${employee.id}"></c:out></th>
                            <td><c:out value="${employee.hoTen}"></c:out></td>
                            <td><c:out value="${employee.ngaySinh}"></c:out></td>
                            <td><c:out value="${employee.soCMND}"></c:out></td>
                            <td><c:out value="${employee.luong}"></c:out></td>
                            <td><c:out value="${employee.sdt}"></c:out></td>
                            <td><c:out value="${employee.email}"></c:out></td>
                            <td><c:out value="${employee.diaChi}"></c:out></td>
                            <c:forEach var="position" items="${positionList}">
                                <c:if test="${employee.idViTri==position.id}">
                                    <td><c:out value="${position.tenViTri}"></c:out></td>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="degree" items="${degreeList}">
                                <c:if test="${employee.idTrinhDo==degree.id}">
                                    <td><c:out value="${degree.trinhDo}"></c:out></td>
                                </c:if>
                            </c:forEach>
                            <c:forEach var="division" items="${divisionList}">
                                <c:if test="${employee.idBoPhan==division.id}">
                                    <td><c:out value="${division.tenBoPhan}"></c:out></td>
                                </c:if>
                            </c:forEach>
                            <td><a class="btn btn-warning" href="/employeeServlet?action=update&id=${employee.id}">Edit</a></td>
                            <td><a class="btn btn-danger" href="/employeeServlet?action=delete&id=${employee.id}">Delete</a></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <ul id="pagination"></ul>
            </div>
        </div>
    </div>

</div>
</body>
</html>
