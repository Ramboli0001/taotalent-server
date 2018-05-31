package com.yicai.taotalent.domain;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;

/**
 * Created by RamboLi
 * Date 2018/4/19 0019
 * Time 11:06
 */
public class Girl {
    @Id
    private Integer id;
    private String userName;
    @Min(value = 18,message = "禁止未成年少女入内！")
    private Integer age;
    public Girl(Integer id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }
    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
