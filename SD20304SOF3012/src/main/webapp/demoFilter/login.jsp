<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/27/2025
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${message} <br>
    Dang nhap: <br>
    <form action="/demo-filter/login" method="post">
        Username: <input type="text" name="username"> <br>
        Password: <input type="text" name="password"> <br>
        <button>Login</button>
    </form>
</body>
</html>
