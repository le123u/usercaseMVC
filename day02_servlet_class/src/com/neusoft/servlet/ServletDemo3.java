package com.neusoft.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("doGet");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("doPost");
    }
}