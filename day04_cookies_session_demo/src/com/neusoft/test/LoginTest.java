package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

/**
 * @author liuboting
 * @date 2020/8/29 19:17
 */

public class LoginTest {
    @Test
    public void test(){
        User user = new User("aa", "123");
        User login = new UserDaoImpl().login(user);
        System.out.println(login);
    }
}
