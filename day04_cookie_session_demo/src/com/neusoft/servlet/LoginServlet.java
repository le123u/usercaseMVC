package com.neusoft.servlet;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 编码
        req.setCharacterEncoding("utf-8");
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        // 先获取预先生成好的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除session验证码
        session.removeAttribute("checkCode_session");
        // 先判断验证码是否正确
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 验证码正确 判断用户名和密码是否正确
            User userLogin = new User(username, password);
            User user = new UserDaoImpl().login(userLogin);
            if(user != null){


                // 登陆成功
                // 将用户的信息存储到session中
                session.setAttribute("user", username);
                // 重定向到success页面  防止表单重复提交
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                // 登录失败
                req.setAttribute("login_error", "用户名或密码错误");
                req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);

            }
        } else {
            // 验证码不一致
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);


        }

    }
}

