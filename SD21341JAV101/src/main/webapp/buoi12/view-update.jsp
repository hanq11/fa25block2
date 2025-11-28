<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/28/2025
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Sua sinh vien</h1>
    <form action="/sinh-vien/update" method="post">
        Id: <input type="text" name="id" value="${sinhVien.id}"> <br>
        Ten: <input type="text" name="ten" value="${sinhVien.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sinhVien.tuoi}"> <br>
        Diem: <input type="text" name="diem" value="${sinhVien.diem}"> <br>
        Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh == true ? "checked" : ""}>
        Nu <input type="radio" name="gioiTinh" value="false" ${!sinhVien.gioiTinh == true ? "checked" : ""}>
        <br>
        <button>Sua</button>
    </form>
</body>
</html>
