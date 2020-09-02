package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest1")
public class CookieTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        boolean flag = false;
        Cookie[] cookies = req.getCookies();
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
                    resp.addCookie(cookie);
//                    String value = cookie.getValue();
                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间是："+value+"</h1>");
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
            resp.addCookie(cookie);
            resp.getWriter().write("<h1>您好欢迎首次访问</h1>");


        }

    }
}
