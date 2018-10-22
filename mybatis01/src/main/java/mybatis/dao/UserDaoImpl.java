package mybatis.dao;

import mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao{

    //需要向dao实现类注入SqlSessionFactory
    //通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
    }


    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById",id);
        sqlSession.commit();
        sqlSession.close();
    }
}
