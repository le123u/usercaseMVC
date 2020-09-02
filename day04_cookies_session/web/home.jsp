<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2020/8/29
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");
    boolean flag = false;
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length>1){
        for(Cookie cookie:cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            if ("lastTime".equals(name)){
                flag = true;
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss");
                String str_date = sdf.format(date);
                cookie.setValue(str_date);
                System.out.println("编码前str_date"+str_date);
                str_date=URLEncoder.encode(str_date,"utf-8");
                System.out.println("编码后str_date"+str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
//                    String value = cookie.getValue();
                response.getWriter().write("<h1>欢迎回来，您上次访问的时间是："+value+"</h1>");
                System.out.println("解码前"+value);
                value = URLDecoder.decode(value,"utf-8");
                System.out.println("解码前"+value);

                break;
            }
        }
    }

    if (cookies == null || cookies.length == 0 || flag == false){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss");
        String str_date = sdf.format(date);
        System.out.println("编码前的str_date"+str_date);
        // URL编码
        str_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后的str_date"+str_date);
        Cookie cookie = new Cookie("lastTime", str_date);
        cookie.setMaxAge(60*60*24*30); // 一个月
        response.addCookie(cookie);
        response.getWriter().write("<h1>您好欢迎首次访问</h1>");


    }


%>
</body>
</html>
