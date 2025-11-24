<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 24-Nov-25
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Sua hoc sinh:
    <form action="/hoc-sinh/sua" method="post">
        Id: <input type="text" name="id" value="${hocSinh.id}"> <br>
        Ten hoc sinh: <input type="text" name="tenHocSinh" value="${hocSinh.tenHocSinh}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${hocSinh.tuoi}"> <br>
        Dang hoc: Dang hoc <input type="radio" name="dangHoc" value="true" ${hocSinh.dangHoc == true ? "checked" : ""}>
        Thoi hoc: <input type="radio" name="dangHoc" value="false" ${hocSinh.dangHoc == false ? "checked" : ""}>
        <br>
        Truong hoc: <select name="truongHoc">
        <c:forEach items="${listTruongHoc}" var="th">
            <option value="${th.id}" label="${th.tenTruong}" ${hocSinh.truongHoc.id == th.id ? "selected" : ""}></option>
        </c:forEach>
        </select>
        <br>
        <button>Sua</button>
    </form>
</body>
</html>
