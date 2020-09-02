package com.liudongdong.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static{
        try{
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
             ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Statement pstmt,Connection conn){
        close(null,pstmt,conn);
    }
    public static void close(ResultSet rs,Statement pstmt,Connection conn){
        if (pstmt != null){
           try{
              pstmt.close();
           }catch (SQLException e){
               e.printStackTrace();
           }
        }
        if (conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
