package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private   JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        // String sql = "select * from user";
        // List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        // return users;
        return template.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(), user.getQq(),user.getEmail());
    }

    @Override
    public void update(User user) {

        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),
                user.getAddress(), user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);

    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
      try{
          String sql = "select * from user where username = ? and password = ?";
          User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
          return user;
      }catch (Exception e){
          e.printStackTrace();
          return null;
      }

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {

        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
//        for (String key:keySet){
//            // 排除分页的条件参数
//            if ("currentPage".equals(key) || "rows".equals(key)){
//                continue;
//            }

            // 获取value值
//            String[] value = condition.get(key);
//            // 判断value是否有值
//            if (value != null && "".equals(value)){
//                sb.append("and"+key+"like ?");
//            }
        //}
        System.out.println("sql findTotalCount" + sb.toString());

        return template.queryForObject(sb.toString(),Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();

        List<Object> params = new ArrayList<>();
        // 添加分页
        sb.append("limit ? , ?");
        params.add(start);
        params.add(rows);

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}
