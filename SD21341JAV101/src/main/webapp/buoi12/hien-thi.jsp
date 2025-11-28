<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/28/2025
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Them sinh vien</h1>
    <form action="/sinh-vien/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Diem: <input type="text" name="diem"> <br>
        Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true">
        Nu <input type="radio" name="gioiTinh" value="false">
        <br>
        <button>Them</button>
    </form>
    <br>
    <h1>Bang thong tin</h1>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Diem</th>
                <th>Gioi tinh</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="sv">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.diem}</td>
                    <td>${sv.gioiTinh == true ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/sinh-vien/view-update?id=${sv.id}">View update</a>
                        <a href="/sinh-vien/delete?id=${sv.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
