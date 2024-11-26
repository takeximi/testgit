<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm Hợp Đồng Bảo Hiểm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Màu nền xám sáng */
            margin: 0;
            padding: 20px;
        }

        h2 {
            color: #343a40; /* Màu chữ cho tiêu đề */
            text-align: center;
        }

        form {
            background-color: #ffffff; /* Màu nền cho form */
            border-radius: 8px; /* Bo góc */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Đổ bóng cho form */
            padding: 20px; /* Padding cho form */
            max-width: 600px; /* Chiều rộng tối đa của form */
            margin: 20px auto; /* Giữa trang */
        }

        label {
            display: block; /* Hiển thị label như một khối */
            margin: 10px 0 5px; /* Khoảng cách phía trên và dưới label */
            font-weight: bold; /* Chữ in đậm */
        }

        input[type="text"],
        input[type="date"],
        input[type="number"] {
            width: 100%; /* Chiếm toàn bộ chiều rộng */
            padding: 10px; /* Padding cho ô input */
            margin-bottom: 15px; /* Khoảng cách phía dưới mỗi ô input */
            border: 1px solid #ced4da; /* Viền xám cho ô input */
            border-radius: 4px; /* Bo góc cho ô input */
            box-sizing: border-box; /* Bao gồm padding và border trong chiều rộng */
        }

        input[type="submit"] {
            background-color: #5cb85c; /* Màu xanh cho nút Lưu */
            color: white; /* Màu chữ trắng */
            border: none; /* Không viền */
            border-radius: 4px; /* Bo góc cho nút */
            padding: 10px 20px; /* Padding cho nút */
            cursor: pointer; /* Con trỏ chuột khi hover */
            font-size: 16px; /* Kích thước chữ cho nút */
        }

        input[type="submit"]:hover {
            background-color: #4cae4c; /* Đổi màu khi hover */
        }

        .error {
            color: red; /* Màu đỏ cho thông báo lỗi */
            font-size: 12px; /* Kích thước chữ nhỏ cho lỗi */
        }

        .message {
            color: green; /* Màu xanh cho thông báo thành công */
            margin-top: 20px; /* Khoảng cách giới thiệu cho thông báo */
            text-align: center; /* Căn giữa */
        }
    </style>
</head>
<body>
<h2>Thêm Dịch Vụ</h2>
<c:if test="${not empty errorMessage}">
    <div style="color:red;">${errorMessage}</div>
</c:if>
<form:form modelAttribute="tieccuoi" action="addTiecCuoi" method="post">
    <label for="id">id:</label>
    <form:input path="id"  />
    <label for="ngayToChuc">Ngày Tổ Chức:</label>
    <form:input path="ngayToChuc" type="date" />

    <label for="tenCoDau">Tên Cô Dâu:</label>
    <form:input path="tenCoDau" />

    <label for="tenChuRe">Tên Chú Rễ:</label>
    <form:input path="tenChuRe" />
    <label for="soLuongBan">Số lượng Bàn:</label>
    <form:input path="soLuongBan" />

    <label for="tienDatCoc">Tiền Đặt Cọc:</label>
    <form:input path="tienDatCoc" />

    <select class="form-select" id="productType" name="productType" path="dichVuDiKem" required>
        <option value="" disabled selected>Chọn Dịch Vụ Đi Kèm</option>
        <c:forEach var="dv" items="${dichvu}">
            <option value="${dv.id_DichVu}">
                    ${dv.tenDichVu}
            </option>
        </c:forEach>
    </select>

    <label for="ghiChu">Ghi Chú:</label>
    <form:input path="ghiChu" />

    <input type="submit" value="Lưu" />
</form:form>

<c:if test="${not empty errorMessage}">
    <div style="color:red ; text-align: center;">${errorMessage}</div>
</c:if>
<a href="viewTiecCuoi">Danh Sách Tiệc Cưới</a>
</body>
</html>
