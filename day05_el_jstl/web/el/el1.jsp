<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/31
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${3>4}--%>
${3>4}
<br>
<%--\${3>4}--%>
\${3>4}
<br>
<h3>算术运算符</h3>
<%--${3+4}--%>
<%--${3*4}--%>
<%--${3/4}--%>
<%--${3%4}--%>
<%--${3 mod 4}--%>
${3+4}
${3*4}
${3/4}
${3%4}
${3 mod 4}
<h3>比较运算符</h3>
<%--${3==4}--%>
${3!=4}
<h3>逻辑运算符</h3>
<%--${3 >4 && 3 < 4}--%>
<%--${3 > 4 and 3 < 4}--%>
${3>4 && 3<4}
${3 > 4 and 3 < 4}
<h3>empty运算符</h3>
<%
//    String str = "";
//    request.setAttribute("str",str);
//    List<Object> list = new ArrayList<>();
//    list.add("haha");
//    request.setAttribute("list",list);
    String str = "";
    request.setAttribute("str",str);
    List<Object> list = new ArrayList<>();
    list.add("haha");
    request.setAttribute("list",list);

%>
<%--${empty }--%>
<%--${empty str}--%>
<%--${empty list}--%>
<%--${not empty str}--%>
<%--${not empty list}--%>
${empty str}
${empty list}
${not empty list}
${not empty list}
</body>
</html>
