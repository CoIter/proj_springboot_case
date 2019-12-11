package com.maxsh.param;

import java.util.StringJoiner;

/**
 * UserInfo
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/11
 */
public class UserInfo {
    private String userName;
    private String email;
    private String introduction;
    private String hobby;

    public UserInfo() {
    }

    public UserInfo(String userName, String email, String introduction, String hobby) {
        this.userName = userName;
        this.email = email;
        this.introduction = introduction;
        this.hobby = hobby;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfo.class.getSimpleName() + "[", "]")
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("introduction='" + introduction + "'")
                .add("hobby='" + hobby + "'")
                .toString();
    }
}
