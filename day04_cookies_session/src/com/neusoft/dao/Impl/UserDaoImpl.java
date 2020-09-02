package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private User user = null;
    @Override
    public User login(User user) {
        try{
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            rs = pstmt.executeQuery();
//            User userLogin = new User();
//            while (resultSet.next()){
//                 userLogin = new User(
//                        resultSet.getString("username"),
//                        resultSet.getString("password")
//                );
//            }
            rs.next();
//            userLogin.setUsername(resultSet.getString("username"));
//            userLogin.setPassword(resultSet.getString("password"));
            return new User(
                    rs.getString("username"),
                    rs.getString("password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return null;
    }
}