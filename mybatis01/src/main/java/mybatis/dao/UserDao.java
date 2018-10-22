package mybatis.dao;

import mybatis.po.User;

import java.io.IOException;

public interface UserDao {

    //更加id查询用户信息
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;
}
