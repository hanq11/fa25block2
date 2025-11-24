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
  Them hoc sinh:
  <form action="/hoc-sinh/them" method="post">
    Ten hoc sinh: <input type="text" name="tenHocSinh"> <br>
    Tuoi: <input type="text" name="tuoi"> <br>
    Dang hoc: Dang hoc <input type="radio" name="dangHoc" value="true">
      Thoi hoc: <input type="radio" name="dangHoc" value="false">
    <br>
    Truong hoc: <select name="truongHoc">
      <c:forEach items="${listTruongHoc}" var="th">
        <option value="${th.id}" label="${th.tenTruong}"></option>
      </c:forEach>
    </select>
    <br>
    <button>Them</button>
  </form>

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
        <th>Hanh dong</th>
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
          <td>
            <a href="/hoc-sinh/view-update?id=${hs.id}">View update</a>
            <a href="/hoc-sinh/xoa?id=${hs.id}">Xoa</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
