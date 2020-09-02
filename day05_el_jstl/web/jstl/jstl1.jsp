<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--c:if
    属性 test必须属性 接受的是boolean表达式
    一般test配合el表达式一起使用
    没有else 部分，想要的话需要在定义一个 c:if
--%>

<%--<c:if test="true">--%>
<%--    <h1>还有一个月就过节了</h1>--%>
<%--</c:if>--%>
<%
    List<Object> list = new ArrayList<>();
    list.add("aaa");
    request.setAttribute("list",list);
    request.setAttribute("number",5);
%>
<c:if test="${not empty requestScope.list}">
    <h2>${list}遍历集合</h2>
</c:if>
<c:if test="${number % 2 != 0}">
    <h2>${number}为奇数</h2>
</c:if>
<c:if test="${number % 2 == 0}">
    <h2>${number}为偶数</h2>
</c:if>
</body>
</html>
