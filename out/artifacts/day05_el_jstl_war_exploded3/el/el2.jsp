<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
// 在域中存储数据
    session.setAttribute("name","李四");
    request.setAttribute("name","张三");
    session.setAttribute("age",23);
    request.setAttribute("str","");
%>
<h3>el获取值</h3>
${requestScope.name}
${sessionScope.name}
${sessionScope.age}
</body>
</html>
