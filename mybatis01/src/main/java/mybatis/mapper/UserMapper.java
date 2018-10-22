package mybatis.mapper;

import mybatis.po.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUserById(int id) throws Exception;

    public void updateUser(User user) throws Exception;

//    //更加id查询用户信息
//    public User findUserById(int id) throws Exception;
//
//    //添加用户信息
//    public void insertUser(User user) throws Exception;
//
//    //删除用户信息
//    public void deleteUser(int id) throws Exception;
}
