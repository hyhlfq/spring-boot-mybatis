package cn.hyh.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User {

    private Integer id;
    private String name;
    private Integer age;

    public User() {}

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
