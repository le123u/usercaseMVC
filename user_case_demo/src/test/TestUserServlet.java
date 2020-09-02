package test;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import org.junit.Test;
import service.Impl.UserServletImpl;

import java.util.List;

public class TestUserServlet {
    @Test
    public void UserServlet(){
        UserDao userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }

    }
}
