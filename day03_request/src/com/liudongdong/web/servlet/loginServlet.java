package com.liudongdong.web.servlet;

import com.liudongdong.dao.Impl.UserDaoImpl;
import com.liudongdong.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginAa")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        UserDaoImpl dao = new UserDaoImpl();
        User user = null;
        try{
            user = dao.login(loginUser);
        }catch(Exception e){
            e.printStackTrace();
        }

        if (user == null){
            req.getRequestDispatcher("/fail").forward(req,resp);
        }else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("/success").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
