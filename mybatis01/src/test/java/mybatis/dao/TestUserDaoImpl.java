package mybatis.dao;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

public class TestUserDaoImpl {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource="SqlMapConfig.xml";
        //根据配置文件得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        //根据配置文件流创建sqlSeesionFactory
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        //创建UserDao对象（创建父对象引用子对象）
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        User user=new User();
        user.setUsername("赵大兴");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("广东佛山");
        userDao.insertUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception{
        UserDao userDao=new UserDaoImpl(sqlSessionFactory);
        userDao.deleteUser(26);
    }
}
