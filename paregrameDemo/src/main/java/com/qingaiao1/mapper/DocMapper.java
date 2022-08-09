package com.qingaiao1.mapper;

import com.qingaiao1.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: H_H
 * @date: 2022/08/08 11:41
 * @description:
 **/
public interface DocMapper {


    List<Doctor> queryDoc ();

    Doctor queryById(Integer id);

    int deleteDoc(ArrayList<Integer> ids);

    int updateDoc(Doctor doctor);

    int insertDoc(Doctor doctor);

    List<Doctor> queryDocAndHos();
}
