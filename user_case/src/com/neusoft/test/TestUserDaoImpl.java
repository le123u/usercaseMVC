package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class TestUserDaoImpl {
//    @Test
//    public void UserDaoImplTest(){
//        UserDao dao = new UserDaoImpl();
//        List<User> users = dao.findAll();
//        for(User user:users){
//            System.out.println(user);
//        }
//    }
//    @Test
//    public void test2(){
//        User user = new User();
//        user.setName("aaaa");
//        user.setGender("男");
//        user.setAge(12);
//        user.setAddress("丹东");
//        user.setQq("123456");
//        user.setEmail("2222@qq.com");
//        UserDaoImpl dao = new UserDaoImpl();
//        dao.add(user);
//    }

//    @Test
//    public void test3() throws InvocationTargetException, IllegalAccessException {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name","cc");
//        map.put("gender","男");
//        map.put("age","13");
//        map.put("address","广东");
//        map.put("qq","3455");
//        map.put("email","223@163.com");
//
//        User user = new User();
//        BeanUtils.populate(user,map);
//        UserDaoImpl dao = new UserDaoImpl();
//        dao.add(user);
//    }
        @Test
    public void test4(){
            UserDaoImpl userDao = new UserDaoImpl();
            User user = userDao.findUserByUsernameAndPassword("aaa", "123");
            System.out.println(user);
        }
}
