package org.qingqiao.entity;

public class Doctor {
    private Integer id;

    private String name;

    private String sex;

    private String address;

    private Hospital hospital;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", hospital=" + hospital +
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Doctor() {
    }

    public Doctor(Integer id, String name, String sex, String address, Hospital hospital) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.hospital = hospital;
    }
}