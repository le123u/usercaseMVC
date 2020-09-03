package com.neusoft.web.servlet;

import com.neusoft.domain.User;
import com.neusoft.service.Impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 设置编码
        req.setCharacterEncoding("utf-8");
        // 获取参数
        Map<String, String[]> map = req.getParameterMap();
//        String name = req.getParameter("name");
//        String sex = req.getParameter("sex");
//        String age = req.getParameter("age");
//        String address = req.getParameter("address");
//        String qq = req.getParameter("qq");
//        String email = req.getParameter("email");


        // 将参数封装成对象
        // 将参数封装成对象
        User user = new User();
//        user.setName(name);
//        user.setGender(sex);
//        user.setAge(Integer.parseInt(age));
//        user.setAddress(address);
//        user.setAddress(qq);
//        user.setAddress(email);
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service  add方法
        UserServiceImpl service = new UserServiceImpl();
        service.addUser(user);
        // 重定向 到首页 list.jsp
//        resp.sendRedirect(req.getContextPath()+"/userListServlet");
        resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
}
