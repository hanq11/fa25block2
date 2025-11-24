<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/24/2025
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua san pham:
    <form action="/san-pham/sua" method="post">
        Ma san pham: <input type="text" name="maSP" value="${sanPham.maSP}"> <br>
        Ten san pham: <input type="text" name="tenSP" value="${sanPham.tenSP}"> <br>
        So luong: <input type="text" name="soLuong" value="${sanPham.soLuong}"> <br>
        Tinh trang: Con hang <input type="radio" name="tinhTrang" value="true" ${sanPham.tinhTrang == true ? "checked" : ""}>
        Het hang: <input type="radio" name="tinhTrang" value="false" ${sanPham.tinhTrang == false ? "checked" : ""}>
        <br>
        <button>Sua</button>
    </form>
</body>
</html>
