package org.qingqiao.mapper;

import java.util.List;
import org.qingqiao.entity.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    Hospital selectByPrimaryKey(Integer id);

    List<Hospital> selectAll();

    int updateByPrimaryKey(Hospital record);
}