<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 12/8/2025
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Cac bai hat: <select name="">
        <c:forEach items="${danhSach}" var="bh">
            <option label="${bh.tenBaiHat}"></option>
        </c:forEach>
    </select> <br>
    <h1>Them bai hat</h1>
    <form action="/bai-hat/add" method="post">
        Ten bai hat: <input type="text" name="tenBaiHat"> ${errorTenBaiHat} <br>
        Gia: <input type="text" name="gia"> ${errorGia}<br>
        Thoi luong: <input type="text" name="thoiLuong"> <br>
        Ngay ra mat: <input type="text" name="ngayRaMat"> <br>
        <button onclick="return confirm('Ban co chac muon them khong')">Them</button>
    </form>
    <br>
    <h1>Bang thong tin</h1>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten bai hat</th>
                <th>Gia</th>
                <th>Thoi luong</th>
                <th>Ngay ra mat</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="bh">
                <tr>
                    <td>${bh.id}</td>
                    <td>${bh.tenBaiHat}</td>
                    <td>${bh.gia}</td>
                    <td>${bh.thoiLuong}</td>
                    <td>${bh.ngayRaMat}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
