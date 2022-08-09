package org.qingqiao.mapper;

import java.util.List;
import org.qingqiao.entity.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    List<Doctor> selectAll();

    int updateByPrimaryKey(Doctor record);
}