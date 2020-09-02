<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Object> list = new ArrayList<>();
    list.add("aaa");
    request.setAttribute("list",list);
    request.setAttribute("number",5);
%>
<c:if test="${not empty requestScope.list}">
    <h2>遍历集合</h2>
</c:if>
<c:if test="${number % 2 == 0}">
    <h2>${number}是偶数</h2>
</c:if>
<c:if test="${number % 2 != 0}">
    <h2>${number}是奇数</h2>
</c:if>
</body>
</html>
