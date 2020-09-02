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

@WebServlet("/cookieTest")
public class CookTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 有cookie  不是第一次访问
         * 没有 是第一次
         */

        resp.setContentType("test/html;charset=utf-8");
        // 获取所有cookie
        boolean flag = false;// 标识有没有cookie 为lastTime
        Cookie[] cookies = req.getCookies();
        // 遍历cookie数组


        if (cookies != null && cookies.length>0){
            for(Cookie cookie:cookies){
                // 获取cookie的名称
                String name = cookie.getName();
                // 判断遍历的cookie 是否为lastTime
                if ("lastTime".equals(name)){
                    // 有 不是第一次
                    flag = true;
                    // 获取当前时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH：mm：ss");
                    String str_date = sdf.format(date);
                    cookie.setValue(str_date);
                    System.out.println("解码前的str_date"+str_date);
                    // URL解码
                    str_date = URLDecoder.decode(str_date, "utf-8");
                    System.out.println("解码后的str_date"+str_date);
                    cookie.setMaxAge(60*60*24*30); // 一个月
                    resp.addCookie(cookie);
                   // 响应数据
                    String value = cookie.getValue();
                    resp.getWriter().write("<h1>欢迎回来，您上次访问的时间是："+value+"</h1>");
                    System.out.println("编码前"+value);
                    // URL编码
                    value = URLEncoder.encode(value, "utf-8");
                    System.out.println("编码后"+value);

                    break;
                }



            }
        }
        if (cookies == null || cookies.length==0 || flag == false){
            // 第一次访问
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
