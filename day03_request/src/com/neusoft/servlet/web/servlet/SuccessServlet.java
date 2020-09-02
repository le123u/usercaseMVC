package com.neusoft.servlet.web.servlet;

import com.neusoft.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 给页面一句话
        User user = (User) req.getAttribute("user");
        if (user != null) {
            // 1.设置编码和返回文件类型
            resp.setContentType("test/html;charset=utf-8");
            resp.getWriter().write("登陆成功，"+user.getUsername()+"，欢迎您");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
