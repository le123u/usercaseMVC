<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h3{
            color: red;
        }
    </style>
</head>
<body>
<h1>尊敬的<%= session.getAttribute("user") %>会员,欢迎您!</h1>
<h3>请您扫码付款，谢谢合作！</h3>
<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598698663239&di=ed6e33c205225717823666dfd7fb1638&imgtype=0&src=http%3A%2F%2Fimg.xinxic.com%2Fimg%2F7de179453ea69b23.jpg" alt="">
</body>
</html>
