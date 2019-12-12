package com.maxsh.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * UserEntity
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/09
 */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = true)
    private String age;
    @Column(nullable = false)
    private String regTime;

    public UserEntity() {
    }

    public UserEntity(String userName, String password, String email, String nickName, String age, String regTime) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.age = age;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("nickName='" + nickName + "'")
                .add("age='" + age + "'")
                .add("regTime='" + regTime + "'")
                .toString();
    }
}
