package com.neusoft.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        // 获取里面的请求方式：GET
        String method = req.getMethod();
        System.out.println("method"+method);//GET
        // 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("contextPath"+contextPath);///day02_servlet_class_war_exploded
        // 获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println("servletPath"+servletPath);///requestDemo1
        // 获取get方式请求参数
        String queryString = req.getQueryString();
        System.out.println("queryString"+queryString);//null
        // 获取URI URL
        String requestURI = req.getRequestURI();
        System.out.println("requestURI"+requestURI);///day02_servlet_class_war_exploded/requestDemo1
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL"+requestURL);// http://localhost/day02_servlet_class_war_exploded/requestDemo1
        // 获取协议版本
        String protocol = req.getProtocol();
        System.out.println("protocol"+protocol);//HTTP/1.1
        // 获取客户机IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr"+remoteAddr);//0:0:0:0:0:0:0:1

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("doPost");
    }
}
