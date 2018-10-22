package mybatis.mapper;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource="SqlMapConfig.xml";
        //根据配置文件得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        //根据配置文件流创建sqlSeesionFactory
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testfindUserById() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        User user=userMapper.findUserById(45);

        sqlSession.close();

        System.out.println(user);
    }

    @Test
    public void testfindUserByName() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //创建UserMapper对象
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //调用userMapper的方法
        List<User> list=userMapper.findUserByName("明");

        sqlSession.close();

        System.out.println(list);
    }

    @Test
    public void testinsertUser() throws Exception{

    }
}