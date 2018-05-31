package com.yicai.taotalent.exception;

import com.yicai.taotalent.enums.ResultEnum;

/**
 * Created by RamboLi
 * Date 2018/4/23 0023
 * Time 15:04
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
