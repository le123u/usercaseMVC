package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 获取所有选中的uid
        String[] uids = req.getParameterValues("uid");
        UserServiceImpl service = new UserServiceImpl();
        service.deleteSelectedUser(uids);
//        resp.sendRedirect(req.getContextPath()+"/userListServlet");
        resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
}
