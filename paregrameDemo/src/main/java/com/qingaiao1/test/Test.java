package com.qingaiao1.test;

import com.qingaiao1.entity.Doctor;
import com.qingaiao1.entity.Hospital;
import com.qingaiao1.mapper.DocMapper;
import com.qingaiao1.mapper.HosMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
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

        //queryDocAndHos(docMapper);

        //queryDoc(docMapper);

        //queryA_Doc(docMapper, 22);

        //insertDoc(docMapper, new Doctor(0,"z4546","男","青h桥",new Hospital(1,null)));

        /*ArrayList<Integer> ids = new ArrayList<>();
        ids.add(25);
        ids.add(26);
        deleteDoc(docMapper, ids);*/

        //updateDoc(docMapper, new Doctor(22,"子涵~~~~","女","青桥",new Hospital(1,null)));


        HosMapper hosMapper = sqlSession.getMapper(HosMapper.class);
        queryHosAndDoc(hosMapper);
        sqlSession.close();
    }

    //查医院及其医生
    private static void queryHosAndDoc(HosMapper hosMapper){
        List<Hospital> hospitalList = hosMapper.queryHosAndDoc();
        for (Hospital hospital : hospitalList) {
            System.out.println(hospital);
        }
    }

    //查医生和医院  多对一
    private static void queryDocAndHos(DocMapper docMapper){
        List<Doctor> doctorList = docMapper.queryDocAndHos();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    //查
    private static void queryDoc(DocMapper docMapper) {

        List<Doctor> doctorList = docMapper.queryDoc();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }

    }

    //查一个
    private static void queryA_Doc(DocMapper docMapper, Integer id) {
        Doctor doctor = docMapper.queryById(id);
        System.out.println(doctor);

    }

    //增
    private static void insertDoc(DocMapper docMapper, Doctor doctor) {
        int i = docMapper.insertDoc(doctor);
        if (i > 0) {
            System.out.println("新增医生:" + doctor);
        }
        queryDoc(docMapper);
    }

    //删
    private static void deleteDoc(DocMapper docMapper, ArrayList<Integer> list) {
        int i = docMapper.deleteDoc(list);

        if (i > 0) {
            System.out.println("已删除条数: " + i);
        }
        queryDoc(docMapper);
    }

    //改
    private static void updateDoc(DocMapper docMapper, Doctor doctor) {
        int i = docMapper.updateDoc(doctor);
        if (i > 0) {
            System.out.println("修改成功");
        }
        queryDoc(docMapper);

    }
}
