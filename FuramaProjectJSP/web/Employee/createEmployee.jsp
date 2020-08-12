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
                <a class="btn btn-info" href="btn btn-info">Show</a>
            </div>
            <div class="col-11">
                <h2>Thêm mới Nhân viên</h2>
                <form action="/employeeServlet" method="get">
                    <input type="hidden" name="action" value="confirmCreate" >
                    <div class="form-group">
                        <label for="">Họ tên Nhân viên</label>
                        <input type="text" name="hoTen" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Ngày sinh </label>
                        <input type="text" name="ngaySinh" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Số CMND</label>
                        <input type="text" name="soCMND" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Lương</label>
                        <input type="text" name="luong" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="">Số điện thoại</label>
                        <input type="text" name="sdt" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Email</label>
                        <input type="text" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Địa chỉ</label>
                        <input type="text" name="diaChi" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Vị trí</label>
                        <select name="idViTri">
                            <c:forEach var="position" items="${positionList}">
                                <option value="${position.id}" ><c:out value="${position.tenViTri}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="">Trình Độ</label>
                        <select name="idTrinhDo">
                            <c:forEach var="degree" items="${degreeList}">
                                <option value="${degree.id}" ><c:out value="${degree.trinhDo}"></c:out></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="">Bộ phận</label>
                        <select name="idBoPhan">
                            <c:forEach var="division" items="${divisionList}">
                                <option value="${division.id}" ><c:out value="${division.tenBoPhan}"></c:out></option>
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
