package cn.hyh.model;

/**
 * @Author : hyh
 * @Email : hyhlfq@163.com
 * @Date : 2016/8/4 0004
 */

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Integer test;

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

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }
}
