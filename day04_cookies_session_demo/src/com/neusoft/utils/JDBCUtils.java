package com.neusoft.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author liuboting
 * @date 2020/8/29 18:57
 */

public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
             ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection conn, Statement pstmt, ResultSet rs) {
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try{
                pstmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn,Statement pstmt){

        close(conn,pstmt,null);

    }
    public static DataSource getDs() {
        return ds;
    }
}
