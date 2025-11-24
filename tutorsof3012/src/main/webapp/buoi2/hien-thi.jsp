<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Syn
  Date: 19-Nov-25
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <select name="">
    <c:forEach items="${listTruongHoc}" var="th">
      <option value="${th.id}" label="${th.tenTruong}"></option>
    </c:forEach>
  </select>
  <br>
  Bang hoc sinh:
  <table>
    <thead>
      <tr>
        <th>Id</th>
        <th>Ten hoc sinh</th>
        <th>Tuoi</th>
        <th>Dang hoc</th>
        <th>Truong hoc</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listHocSinh}" var="hs">
        <tr>
          <td>${hs.id}</td>
          <td>${hs.tenHocSinh}</td>
          <td>${hs.tuoi}</td>
          <td>${hs.dangHoc == true ? "Dang hoc" : "Thoi hoc"}</td>
          <td>${hs.truongHoc.tenTruong}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
