<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 冯庆
  Date: 2018/6/28
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <shiro:user>
        欢迎访问:<shiro:principal></shiro:principal><br>
        <a href="/logout">登出</a><br><br>
    </shiro:user>
    <a href="/admin.jsp">admin page</a><br><br>
    <a href="/annotation">annotation</a>









</body>
</html>
