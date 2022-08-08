package com.qingaiao1.entity;

/**
 * @author: H_H
 * @date: 2022/08/08 11:40
 * @description:
 **/
public class Hospital {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public Hospital(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
