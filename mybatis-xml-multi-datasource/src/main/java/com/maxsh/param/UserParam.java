package com.maxsh.param;

import java.util.StringJoiner;

/**
 * UserParam
 *
 * @author maxsc
 * @description: TODO
 * @date 2019/12/05
 */
public class UserParam extends PageParam{

    private String name;

    private String sex;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", UserParam.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("sex='" + sex + "'")
                .toString();
    }
}
