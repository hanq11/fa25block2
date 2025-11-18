<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 18-Nov-25
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Form them sinh vien:
    <form action="/sinh-vien/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        Nam sinh: <input type="text" name="namSinh"> <br>
        Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true">
            Nu <input type="radio" name="gioiTinh" value="false">
        <br>
        <button>Add</button>
    </form>
    <br>
    Bang sinh vien:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Dia chi</th>
                <th>Nam sinh</th>
                <th>Gioi tinh</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSinhVien}" var="sv">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.namSinh}</td>
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
