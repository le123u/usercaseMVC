package com.neusoft.web.servlet;

import com.neusoft.domain.PageBean;
import com.neusoft.domain.User;
import com.neusoft.service.Impl.UserServiceImpl;
import com.neusoft.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取参数
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            // 默认5条
            currentPage = "5";
        }
        // 获取条件查询参数
        Map<String, String[]> condition = req.getParameterMap();

        // service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows, condition);

        // 存入
        req.setAttribute("pb",pb);
        req.setAttribute("condition",condition);
        // 返回
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
