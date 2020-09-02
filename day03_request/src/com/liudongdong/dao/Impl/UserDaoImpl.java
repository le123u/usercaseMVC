package com.liudongdong.dao.Impl;

import com.liudongdong.dao.UserDao;
import com.liudongdong.domain.User;
import com.liudongdong.utils.JDBCUtils;

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
    public User login(User loginUser) {
        try{
             conn = JDBCUtils.getConnection();
             String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
             pstmt.setString(1,loginUser.getUsername());
             pstmt.setString(2,loginUser.getPassword());
             rs = pstmt.executeQuery();
             while(rs.next()){
                  user = new User();
                  user.setUsername(rs.getString("username"));
                  user.setPassword(rs.getString("password"));
             }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return user;
    }
}
