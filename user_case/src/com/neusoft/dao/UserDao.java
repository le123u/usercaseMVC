package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    // 用户操作dao
    public List<User> findAll();


    void add(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

    public User findUserByUsernameAndPassword(String username, String password);

    // 查询总记录数
    int findTotalCount(Map<String,String[]> condition);
    // 分页查询
    List<User> findByPage(int start, int rows, Map<String,String[]> condition);
}
