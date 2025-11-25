<%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/25/2025
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("pageMessage", "Cai nay tu page");
    String pageMessage = (String) pageContext.getAttribute("pageMessage");
%>
<body>
    Message lay tu request: ${message} <br>
    Message lay tu session: ${sessionScope.fromSession} <br>
    Message lay tu application scope: ${applicationScope.applicationMessage} <br>
    Message lay tu page: ${pageMessage}
</body>
</html>
