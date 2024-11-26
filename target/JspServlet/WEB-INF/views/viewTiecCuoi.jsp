
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Xem Danh Sách Tiệc Cưới</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #f4f4f4;
    }

    h2 {
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #984b00;
        color: white;
    }

    td a {
        color: #007BFF;
        text-decoration: none;
        margin-right: 10px; /* khoảng cách giữa các nút */
    }

    td a:hover {
        text-decoration: underline;
    }

    .message {
        color: green;
        margin-top: 20px;
    }
    .delete {
        color: red; /* Đổi màu cho nút xóa */
    }

</style>
<body>

<form method="get" action="viewTiecCuoi">
    Tìm Kiếm Theo Tên: <input type="text" name="ten" />
    <input type="submit" value="Tìm Kiếm" />
</form>

<h1>Danh Sách Tiệc Cưới</h1>

<table id="data-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ngay Tổ Chức</th>
        <th>Tên Cô Dâu</th>
        <th>Tên Chú Rễ</th>
        <th>Số Lượng Bán</th>
        <th>Đơn giá</th>
        <th>Dịch vụ đi kèm</th>
        <th>Tiền Đặt Cọc</th>
        <th>Tiền Thanh Toán</th>
        <th>Ngày Đặt Cọc</th>
        <th>Ngày Thanh Toán</th>
        <th>Ghi Chú</th>
        <th>Trạng Thái</th>
        <th></th>
    </tr>
    </thead>
    <tbody id="myTable">
    <c:forEach var="tc" items="${danhSachTiecCuoi}">
        <tr>
            <td>${tc[0]}</td>
            <td>${tc[1]}</td>
            <td>${tc[2]}</td>
            <td>${tc[3]}</td>
            <td>${tc[4]}</td>
            <td>${tc[5]}</td>
            <td>${tc[6]}</td>
            <td>${tc[7]}</td>
            <td>${tc[8]}</td>
            <td>${tc[9]}</td>
            <td>${tc[10]}</td>
            <td>${tc[11]}</td>
            <td>${tc[12]}</td>

            <td>
                <a class="delete" href="deleteTiecCuoi?id=${tc[0]}" onclick="return confirm('Bạn có chắc chắn muốn xóa hợp đồng này không?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<c:if test="${not empty message}">
    <div style="color:green;">${message}</div>
</c:if>
<a href="addTiecCuoi">Thêm Tiệc Cưới</a>
</body>
</html>
