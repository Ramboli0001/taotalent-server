package com.yicai.taotalent.enums;

/**
 * Created by RamboLi
 * Date 2018/5/5 0005
 * Time 16:36
 */
public enum  PageableEnum {

    DEFAULT_PAGE("1"),
    DEFAULT_PAGESIZE("100");
    private String msg;
    PageableEnum(final String msg) {
        this.msg = msg;
    }
//
//    public String getMsg() {
//        return msg;
//    }

    @Override
    public String toString(){
        return msg;
    }

}
