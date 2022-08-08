package com.qingaiao1.test;

import com.qingaiao1.entity.Doctor;
import com.qingaiao1.entity.Hospital;
import com.qingaiao1.mapper.DocMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author: H_H
 * @date: 2022/08/08 11:37
 * @description:
 **/
public class Test {

    public static void main(String[] args) throws IOException {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = factory.openSession(true);

        DocMapper docMapper = sqlSession.getMapper(DocMapper.class);

        //queryDoc(docMapper);

        //queryA_Doc(docMapper, 22);

        //insertDoc(docMapper, new Doctor(0,"z4546","男","青h桥",new Hospital(1,null)));

        //deleteDoc(docMapper, 11);s

        //updateDoc(docMapper, new Doctor(22,"子涵~~~~","女","青桥",new Hospital(1,null)));

    }
    //查
    private static void queryDoc (DocMapper docMapper){

        List<Doctor> doctorList = docMapper.queryDoc();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }

    }

    //查一个
    private static void queryA_Doc(DocMapper docMapper,Integer id){
        Doctor doctor = docMapper.queryById(id);
        System.out.println(doctor);

    }

    //增
    private static void insertDoc(DocMapper docMapper,Doctor doctor){
        int i = docMapper.insertDoc(doctor);
        if (i>0){
            System.out.println("新增医生:"+doctor);
        }
        queryDoc(docMapper);
    }

    //删
    private static void deleteDoc(DocMapper docMapper,Integer id){
        int i = docMapper.deleteDoc(id);

        if (i>0){
            System.out.println("已删除原id: "+id);
        }
        queryDoc(docMapper);
    }

    //改
    private static void updateDoc(DocMapper docMapper,Doctor doctor){
        int i = docMapper.updateDoc(doctor);
        if (i>0){
            System.out.println("修改成功");
        }
        queryDoc(docMapper);

    }
}