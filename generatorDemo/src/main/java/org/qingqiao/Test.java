package org.qingqiao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qingqiao.entity.Doctor;
import org.qingqiao.entity.Hospital;
import org.qingqiao.mapper.DoctorMapper;
import java.io.IOException;

/**
 * @author: H_H
 * @date: 2022/08/09 18:49
 * @description:
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = factory.openSession();
        DoctorMapper mapper = sqlSession.getMapper(DoctorMapper.class);
        int i = mapper.insert(new Doctor(null, "二福", "女", "阿斯顿发生乡", new Hospital(3, null, null)));
        sqlSession.commit();
        System.out.println(i);



    }
}
