package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.调用 UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.finaAll();
        // 2.将数据放入request中
        req.setAttribute("users",users);
        // 3.转发到list.jsp页面中
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
