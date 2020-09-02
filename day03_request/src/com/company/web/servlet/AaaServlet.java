package com.company.web.servlet;



import com.company.dao.Impl.UserDaoImpl;
import com.company.domain.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
//@WebServlet("/loginServlet")
@WebServlet("/loginSs")
public class AaaServlet extends HttpServlet {
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
       }catch (Exception e){
           e.printStackTrace();
       }

        if (user == null){
            req.getRequestDispatcher("/failSs").forward(req,resp);
        }else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successSs").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
