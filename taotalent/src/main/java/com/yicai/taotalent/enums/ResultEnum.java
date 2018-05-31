package com.yicai.taotalent.enums;

/**
 * Created by RamboLi
 * Date 2018/4/23 0023
 * Time 15:39
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你大概还在上小学吧？"),
    MIDDLE_SCHOOL(101,"你大概在上中学吧？"),
    UNIVERSITY(102,"你大概已经大学毕业了吧？"),
    ANCHORID_EXIST(1001,"主播ID已存在");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
