package service.Impl;

import dao.Impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServletImpl implements UserService {
    private  UserDaoImpl dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
