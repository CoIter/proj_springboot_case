package com.maxsh.model;

import com.maxsh.enums.UserSexEnum;

import java.util.StringJoiner;

/**
 * User
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/05
 */
public class User {
    private long        id;
    private String      name;
    private String      password;
    private UserSexEnum sex;
    private int         age;

    public User() {
    }

    public User(String name, String password, UserSexEnum sex, int age) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("password='" + password + "'")
                .add("sex=" + sex)
                .add("age=" + age)
                .toString();
    }
}
