package com.neusoft.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookDemo1")
public class CookDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie = new Cookie("id", "aaaaaaallsssslssss");
        Cookie cookie2 = new Cookie("id2", "weiowioewowwww");

        // 发送cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie2);



    }
}
