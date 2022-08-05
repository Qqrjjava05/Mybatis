package com.qingqiao.main;

import com.qingqiao.entity.User;
import com.qingqiao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author H_H
 * @date 2022/08/05 14:27
 **/
public class Main {

    public static void main(String[] args) throws IOException {
        //获取数据资源
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //建个session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //工厂造个会话
        SqlSession sqlSession = factory.openSession();
        //得到映射                                接口类?
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //queryById(mapper);

        update(mapper,sqlSession);

        insert(mapper,sqlSession);

        delete(mapper,sqlSession);

        query(mapper);

    }

    //查
    private static void query(UserMapper userMapper) {
        List<User> list = userMapper.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    //查一个
    private static void queryById(UserMapper userMapper) {
        User user = userMapper.queryById(5);
        System.out.println(user);
    }

    //增
    private static void insert(UserMapper userMapper, SqlSession sqlSession) {
        //想添加的对象
        User user = new User(1, "fanzhihan", "fanzihan");
        //受影响行数
        int i = userMapper.insert(user);
        //提交事务
        sqlSession.commit();

    }

    //删
    private static void delete(UserMapper userMapper, SqlSession sqlSession) {
        //受影响行数
        int i = userMapper.delete(1);
        sqlSession.commit();
        System.out.println(i);
    }

    //改
    private static void update(UserMapper userMapper, SqlSession sqlSession){
        User user = new User(2, "范子晗", "mime");
        int i = userMapper.update(user);
        sqlSession.commit();
        System.out.println(i);
    }
}
