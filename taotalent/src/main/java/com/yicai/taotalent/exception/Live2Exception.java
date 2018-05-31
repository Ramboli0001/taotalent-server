package com.yicai.taotalent.exception;

import com.yicai.taotalent.enums.ResultEnum;

/**
 * Created by RamboLi
 * Date 2018/5/3 0003
 * Time 23:35
 */
public class Live2Exception extends RuntimeException{
    private Integer code;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Live2Exception(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
