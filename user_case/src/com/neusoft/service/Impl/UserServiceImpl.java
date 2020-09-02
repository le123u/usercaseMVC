package com.neusoft.service.Impl;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domain.PageBean;
import com.neusoft.domain.User;
import com.neusoft.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> finaAll() {
        // 调用DAO
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        // 添加用户
        dao.add(user);
    }

    @Override
    public void updateUser(User user) {
        // 修改用户
        dao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
       return dao.findById(Integer.parseInt(id));
    }

    @Override
    public User loginUser(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void deleteSelectUser(String[] ids) {
        // 根据id批量删除数据
        if(ids != null && ids.length>0){
            for(String id:ids){
                dao.delete(Integer.parseInt(id));
            }
        }
    }
    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows,Map<String, String[]> condition){
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0){
            currentPage = 1;
        }
        // 创建PageBean对象
        PageBean<User> pb = new PageBean();
        // 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 调用dao的查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 调用dao分页查询
        int start = (currentPage-1)*rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        // 计算总页码
        pb.setTotalPage(totalCount%rows == 0 ? totalCount/rows : totalCount/rows+1);

        return pb;
    }
}
