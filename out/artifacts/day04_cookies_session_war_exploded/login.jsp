<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/29
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        window.onload = function () {
            document.querySelector("#img").onclick = function () {
                this.src="/checkServlet?time"+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name = "username"></td>

        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name = "password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name = "checkCode"></td>
        </tr>
        <tr>
        <td colspan="2"><img src="/checkServlet" alt="" id="img">
            <a href="">点击图片更换验证码</a></td>

    </tr>
        <tr>
            <td><input type="submit" value="登录"></td>

        </tr>
    </table>
</form>
<div><%= request.getAttribute("login_error") == null ? "":request.getAttribute("login_error")%></div>
<div><%= request.getAttribute("cc_error") == null ? "":request.getAttribute("cc_error")%></div>
</body>
</html>
