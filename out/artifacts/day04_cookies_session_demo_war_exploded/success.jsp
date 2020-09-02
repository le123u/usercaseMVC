<%--
  Created by IntelliJ IDEA.
  User: LiuBoTing
  Date: 2020/8/29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>尊敬的<%= request.getSession().getAttribute("user")%>,欢迎您！！！</h1>
success
<img src="web/img/小猫.jpg" alt="">
</body>
</html>
