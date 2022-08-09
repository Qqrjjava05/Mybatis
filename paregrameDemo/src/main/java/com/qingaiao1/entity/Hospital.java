package com.qingaiao1.entity;

import java.util.List;

/**
 * @author: H_H
 * @date: 2022/08/08 11:40
 * @description:
 **/
public class Hospital {
    private Integer id;
    private String name;
    private List<Doctor> doctors;

    public Hospital(Integer id, String name, List<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hospital() {
    }

}
