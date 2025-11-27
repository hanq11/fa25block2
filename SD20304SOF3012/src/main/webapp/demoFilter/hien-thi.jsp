<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/27/2025
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Ban dang truy cap voi tai khoan la: ${sessionScope.taiKhoan} <br>
    Voi quyen la: ${sessionScope.chucVu} <br>
    <a href="/demo-filter/logout">Logout</a>
</body>
</html>
