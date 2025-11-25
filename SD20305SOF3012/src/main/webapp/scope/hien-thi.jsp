<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lovep
  Date: 11/25/2025
  Time: 2:56 PM
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
    Message lay tu request: ${requestMessage} <br>
    Message lay tu session: ${sessionScope.sessionMessage} <br>
    Message lay tu application: ${applicationScope.applicationMessage} <br>
    Message lay tu page: ${pageMessage}
</body>
</html>
