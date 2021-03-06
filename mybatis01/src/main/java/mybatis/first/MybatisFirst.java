package mybatis.first;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirst {

    //根据id查询用户信息，得到一条记录结果
    @Test
    public  void findUserByIdTest() throws IOException {

        String resource="SqlMapConfig.xml";

        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数：映射文件中statement的id，=namespace.statementid
        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        //sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        User user=sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException{

        String resource="SqlMapConfig.xml";

        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> list = sqlSession.selectList("test.findUserByName", "陈小明");
        List<User> userList = sqlSession.selectList("test.findUserByName", "明");
        System.out.println(userList);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void insertUserTest() throws IOException{
        String resource="SqlMapConfig.xml";

        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user=new User();
        user.setUsername("李小明");
        user.setBirthday(new Date());
        user.setSex("0");
        user.setAddress("广东深圳");

        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();

    }

    @Test
    public void deleteUserByIDTest() throws IOException{
        String resource="SqlMapConfig.xml";

        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById",44);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() throws IOException{
        String resource="SqlMapConfig.xml";

        InputStream inputStream= Resources.getResourceAsStream(resource);       //创建会话工厂
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user=new User();
        user.setId(45);
        user.setUsername("张小鹏");
        user.setBirthday(new Date());
        user.setSex("0");
        user.setAddress("广东惠州");

        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        sqlSession.close();

    }

}
