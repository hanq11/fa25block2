<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/21/2025
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Bang thong tin:
    <table>
        <thead>
            <tr>
                <th>Ma SP</th>
                <th>Ten SP</th>
                <th>So luong</th>
                <th>Tinh trang</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="sp">
                <tr>
                    <td>${sp.maSP}</td>
                    <td>${sp.tenSP}</td>
                    <td>${sp.soLuong}</td>
                    <td>${sp.tinhTrang == true ? "Con hang" : "Het hang"}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
