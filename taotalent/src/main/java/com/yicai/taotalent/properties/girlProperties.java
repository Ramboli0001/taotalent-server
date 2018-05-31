package com.yicai.taotalent.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by RamboLi
 * Date 2018/4/18 0018
 * Time 16:47
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class girlProperties {
    private String cupSize;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

}
