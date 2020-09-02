package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookDemo3")
public class CookDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("hehe", "hahahahahahha");
//        // 负数设置是默认 默认cookies是会话级别
//        cookie.setMaxAge(-1);
//        // 删除cookies
//        cookie.setMaxAge(0);
        cookie.setMaxAge(30);

        // 设置一个path让服务器下所有的项目共享cookie信息
        // cookie.setPath("/");
        resp.addCookie(cookie);

    }
}
