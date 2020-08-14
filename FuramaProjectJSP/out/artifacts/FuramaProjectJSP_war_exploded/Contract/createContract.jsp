<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
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
                <a href="">Employee</a>
            </div>
            <div class="col-2">
                <a href="">Customer</a>
            </div>
            <div class="col-2">
                <a href="">Service</a>
            </div>
            <div class="col-2">
                <a href="">Contact</a>
            </div>
            <div class="col-2">
                <input type="text" class="form-control" placeholder="search">
            </div>

        </div>
    </div>
</div>
<br><br>
<div class="content" >
    <div class="container">
        <div class="row">
            <div class="col-1" style="display: flex;flex-direction: column;justify-content: flex-start;align-items: flex-start;background-color: rgb(231, 231, 231)">
                <a class="btn btn-primary" href="">Create</a>
                <br>
                <a class="btn btn-info" href="/contractServlet?action=createContractDetail">Tạo Hợp đồng chi tiết</a>
            </div>
            <div class="col-11">
                <h2>Thêm mới Dịch vụ</h2>
                <form action="/contractServlet" method="get">
                    <input type="hidden" name="action" value="confirmCreate" >
                    <div class="form-group">
                        <label for="">Ngày làm hợp đồng</label>
                        <input type="text" name="ngayLamHopDong" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Ngày Kết Thúc</label>
                        <input type="text" name="ngayKetThuc" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Tiền đặt cọc</label>
                        <input type="text" name="tienDatCoc" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Tổng Tiền</label>
                        <input type="text" name="tongTien" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="">Nhân viên thực hiện</label>
                        <select name="idNhanVien">
                            <c:forEach var="employee" items="${employeeList}">
                                <option value="${employee.id}" ><c:out value="${employee.hoTen}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="">Tên khách hàng</label>
                        <select name="idKhachHang">
                            <c:forEach var="customer" items="${customerList}">
                                <option value="${customer.id}" ><c:out value="${customer.hoTen}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="">Tên dịch vụ</label>
                        <select name="idDichVu">
                            <c:forEach var="service" items="${serviceList}">
                                <option value="${service.id}" ><c:out value="${service.tenDichVu}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Submit"/>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
