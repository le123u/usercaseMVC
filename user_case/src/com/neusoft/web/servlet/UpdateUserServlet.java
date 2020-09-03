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

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
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
        //
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 调用service  update方法
        UserServiceImpl service = new UserServiceImpl();
        service.update(user);
        // 重定向 到首页 list.jsp
//        resp.sendRedirect(req.getContextPath()+"/userListServlet");
        resp.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
}
