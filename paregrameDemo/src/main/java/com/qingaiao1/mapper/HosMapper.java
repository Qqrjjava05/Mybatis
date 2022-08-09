package com.qingaiao1.mapper;

import com.qingaiao1.entity.Hospital;

import java.util.List;

public interface HosMapper {
    //查询医院及其医生
    List<Hospital> queryHosAndDoc();

}
