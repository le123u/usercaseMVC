<%@ page import="com.neusoft.el.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 9:35
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
        user.setName("小桌子");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

        List<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(user);
        request.setAttribute("list",list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("sname","找死");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);

    %>

<h1>el获取对象中的值</h1>
${requestScope.u}
${requestScope.u.name}
<%--对象属性获取
    setter或者getter方法 去掉set 和 get 将剩余部分首字母变为小写
--%>
${u.birthday}

<h3>获取list值</h3>
    ${requestScope.list}
    ${list}
    ${list[0]}
    ${list[3].name}
    <h5>list[10]</h5>
    ${list[10]}
<h3>获取map值</h3>
    ${requestScope.map}
    ${map.gender}
    ${map["gender"]}
    ${map.user.name}
</body>
</html>
