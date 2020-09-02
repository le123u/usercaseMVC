package com.liudongdong.Test;

import com.liudongdong.dao.Impl.UserDaoImpl;
import com.liudongdong.domain.User;
import org.junit.Test;

public class Web_Test {

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
