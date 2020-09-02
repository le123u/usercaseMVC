<%@ page import="com.neusoft.el.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setName("aaa");
    user.setAge(12);
    user.setBirthday(new Date());
    request.setAttribute("user",user);

    List<Object> list = new ArrayList<>();
    list.add("aa");
    list.add(user);
    request.setAttribute("list",list);

    HashMap<Object, Object> map = new HashMap<>();
    map.put("aa","aa");
    map.put("user",user);
    request.setAttribute("map",map);

%>
${requestScope.user}
<br>
${requestScope.list}
<br>
${requestScope.map}
</body>
</html>
