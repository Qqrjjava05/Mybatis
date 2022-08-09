package org.qingqiao.entity;

import java.util.List;

public class Hospital {
    private Integer id;

    private String name;

    private List<Doctor> doctorList;

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctorList=" + doctorList +
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

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public Hospital() {

    }

    public Hospital(Integer id, String name, List<Doctor> doctorList) {
        this.id = id;
        this.name = name;
        this.doctorList = doctorList;
    }
}