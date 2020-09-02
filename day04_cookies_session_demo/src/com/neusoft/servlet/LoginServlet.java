package com.neusoft.servlet;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuboting
 * @date 2020/8/29 14:31
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        //先获取预先生成好的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");

        //删除session验证码
        session.removeAttribute("checkCode_session");

        //先判断验证码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            // 判断用户名和密码是否正确
            User userLogin = new User(username, password);
            if(new UserDaoImpl().login(userLogin) != null){
                //TODO 调用UserDao查询数据库
                //登录成功
                //将用户的信息存储到session里
                session.setAttribute("user",username);
                //重定向到success.jsp
                resp.sendRedirect(req.getContextPath()+"/success.jsp");
            }else {
                //登录失败
                req.setAttribute("login_error","用户名或密码错误");
                req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,resp);
            }
        }else {
            //验证码不一致
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher(req.getContextPath()+"/login.jsp").forward(req,resp);
        }

    }
}
