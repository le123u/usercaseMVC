package com.neusoft.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/requestdemo04")
public class RequestDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String queryString = req.getQueryString();
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        String protocol = req.getProtocol();
        String remoteAddr = req.getRemoteAddr();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
