package com.neusoft.servlet.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 转发资源
        System.out.println("demo01");
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo5");
       requestDispatcher.forward(req,resp);
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo5");
       // requestDispatcher.forward(req,resp);

        // 转发时存储数据到request中
//        req.setAttribute("msg","hello");
//        req.getRequestDispatcher("/requestDemo5").forward(req,resp);

        // 只能转发到当前项目下的地址
       // req.getRequestDispatcher("http://www.neusoft.com").forward(req,resp);
    }
    }
