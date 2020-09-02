package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test(){
        User loginUser = new User();
        loginUser.setUsername("张三");
        loginUser.setPassword("abc");
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.login(loginUser);
        System.out.println(user);

    }
}
