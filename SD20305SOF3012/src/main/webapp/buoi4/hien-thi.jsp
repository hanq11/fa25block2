<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/11/2025
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Them giang vien:
    <form action="/giang-vien/add" method="post">
        Ten: <input type="text" name="tenGiangVien"> <br>
        Tuoi: <input type="text" name="tuoi"> <br>
        Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true">
                Nu <input type="radio" name="gioiTinh" value="false">
        <br>
        Truong hoc:
        <select name="idTruong">
            <c:forEach items="${listTruongHoc}" var="th">
                <option value="${th.id}" label="${th.tenTruong}"></option>
            </c:forEach>
        </select>
        <br>
        <button>Submit</button>
    </form>
    <br>
    Bang giang vien:
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
                <th>Truong hoc</th>
                <th>Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listGiangVien}" var="gv">
                <tr>
                    <td>${gv.id}</td>
                    <td>${gv.tenGiangVien}</td>
                    <td>${gv.tuoi}</td>
                    <td>${gv.gioiTinh == true ? "Nam" : "Nu"}</td>
                    <td>${gv.truongHoc.tenTruong}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
