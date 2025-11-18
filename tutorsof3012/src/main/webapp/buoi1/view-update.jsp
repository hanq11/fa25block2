<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 18-Nov-25
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  Form sua sinh vien:
  <form action="/sinh-vien/update" method="post">
    Id: <input type="text" name="id" value="${sinhVien.id}"> <br>
    Ten: <input type="text" name="ten" value="${sinhVien.ten}"> <br>
    Dia chi: <input type="text" name="diaChi" value="${sinhVien.diaChi}"> <br>
    Nam sinh: <input type="text" name="namSinh" value="${sinhVien.namSinh}"> <br>
    Gioi tinh: Nam <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh == true ? "checked" : ""}>
    Nu <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh == false ? "checked" : ""}>
    <br>
    <button>Update</button>
  </form>
</body>
</html>
