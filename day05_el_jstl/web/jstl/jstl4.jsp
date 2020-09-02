<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach标签</title>
</head>
<body>
<%
%>
<%--<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">--%>
<%--    ${i}--%>
<%--    <h3>index${s.index}</h3>--%>
<%--    <h4>count${s.count}</h4>--%>
<%--</c:forEach>--%>
<hr>
<%
    List<Object> list = new ArrayList<>();
    list.add("小鲁班");
    list.add("妲己");
    list.add("后羿");
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="str" varStatus="s">
   ${s.index}----${s.count}
    ${str}
</c:forEach>
</body>
</html>
